package snippets.sistemaController;

import estructuras.cola.ICola;
import estructuras.cola.implementacion.Cola;
import estructuras.conjunto.IConjunto;
import estructuras.conjunto.implementacion.ConjuntoStr;
import estructuras.diccionario.IDiccionario;
import estructuras.linkedlist.ILinkedList;
import estructuras.linkedlist.implementacion.LinkedList;
import snippets.productoController.Producto;

public class SistemaController {
    ICola colaPedidos = new Cola();
    ILinkedList historialPedidos = new LinkedList();
    IConjunto<Producto> productos;

    public SistemaController(IConjunto<Producto> productosCtrl) // Operación de tiempo constante (O(1)).
    {
        this.colaPedidos.inicializarCola();
        this.historialPedidos.inicializarLinkedList();
        this.productos = productosCtrl;
    }

    private Pedido crearPedido() //Operación de tiempo constante (O(1)).
    {
        Pedido nuevoPedido = new Pedido(0);
        colaPedidos.acolar(nuevoPedido);
        return nuevoPedido;
    }

    private void mostrarInfoPedidos(int id, int estado, IDiccionario productosPedido) //Operación cúbica (O(N ** 3)).
    {
        String estadoMostrar = switch (estado) {
            case 0 -> "Pendiente";
            case 1 -> "En preparación";
            case 2 -> "Listo";
            case 3 -> "Cancelado";
            default -> "Indefinido";
        };

        System.out.print("\n--------------------");
        System.out.printf("\nN°%4s | %s\n", id, estadoMostrar);

        ConjuntoStr clavesPedido = productosPedido.identificadores();

        double total = 0;

        while (!clavesPedido.conjuntoVacio())
        {
            String nombre = clavesPedido.elegir();
            int cantidad = productosPedido.recuperar(nombre);
            Producto p = productos.sacar(nombre.toLowerCase());

            double subtotal = cantidad * p.precio;
            productos.agregar(p);

            total += subtotal;
            System.out.printf("\n%s x %s = %s", nombre, cantidad, subtotal);
            clavesPedido.sacar(nombre);
        }

        System.out.println("\n\nTOTAL: " + total);
    }

    // como mejora, en vez de filtrar los pedidos por "pendientes" damos la opción
    // al usuario de optar el filtro de los pedidos que desea ver. En caso de querer ver todos los pedidos
    // que están en la cola, tendrá que elegir el identificador "4".
    public void verColaPedidos(int filtroEstadoId) // Operación cuadrática (O(N ** 3)).
    {
        ICola copiaCola = new Cola();
        copiaCola.inicializarCola();

        System.out.printf("\n%3s | %6s", "PEDIDO", "ESTADO");
        while (!colaPedidos.colaVacia())
        {
            Pedido p = colaPedidos.primero();
            copiaCola.acolar(p);

            if (p.estado == filtroEstadoId || filtroEstadoId == 4)
                mostrarInfoPedidos(p.pedidoID, p.estado, p.productosEnPedido);

            colaPedidos.descolar();
        }

        while (!copiaCola.colaVacia())
        {
            colaPedidos.acolar(copiaCola.primero());
            copiaCola.descolar();
        }
    }

    public void modificarEstado(int id, int nuevoEstado) // Operación cuadrática (O(N ** 2))
    {
        ICola aux = new Cola();
        aux.inicializarCola();
        while(!colaPedidos.colaVacia())
        {
            Pedido p = colaPedidos.primero();
            if(p.pedidoID == id)
            {
                if(!(nuevoEstado < p.estado))
                {
                    p.estado = nuevoEstado;
                    if(p.estado == 2 || p.estado == 3)
                    {
                        historialPedidos.add(p);
                    }
                }
            }
            if(p.estado != 3 && p.estado != 2)
            {
                aux.acolar(p);
            }

            colaPedidos.descolar();

        }
        while(!aux.colaVacia())
        {
            colaPedidos.acolar(aux.primero());
            aux.descolar();
        }
    }

    //Devolver a historialPedidos??
    public void verHistorialPedidos() // Operación lineal (O(N ** 2)).
    {
        ILinkedList listaAux = new LinkedList();
        listaAux.inicializarLinkedList();

        System.out.printf("\n%3s | %6s ", "PEDIDO", "ESTADO");
        while(!historialPedidos.listaVacia()){
            Pedido poppeado = historialPedidos.pop();

            mostrarInfoPedidos(poppeado.pedidoID, poppeado.estado, poppeado.productosEnPedido);
            listaAux.unShift(poppeado);
        }
        while(!listaAux.listaVacia()){
            historialPedidos.unShift(listaAux.pop());
        }
    }

    public void crearPedidoProductos(String descripcionPedido) //Operación cúbica (O(N ** 3)).
    {
        Pedido p = null;
        String[] pedidos = descripcionPedido.split(";");

        for(String pedido: pedidos)
        {
            String nombreProducto = pedido.split(",")[0].strip().toLowerCase();
            int cantidad = Integer.parseInt(pedido.split(",")[1].trim());

            if(productos.pertenece(nombreProducto.strip()))
            {
                if(p == null)
                    p = crearPedido();

                p.addProducto(nombreProducto.toUpperCase(), cantidad);
            }
        }
    }
}
