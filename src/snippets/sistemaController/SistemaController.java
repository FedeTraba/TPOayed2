package snippets.sistemaController;

import estructuras.cola.ICola;
import estructuras.cola.implementacion.Cola;
import estructuras.linkedlist.ILinkedList;
import estructuras.linkedlist.implementacion.LinkedList;

public class SistemaController {
    ICola colaPedidos = new Cola();
    ILinkedList historialPedidos = new LinkedList();

    public SistemaController()
    {
        colaPedidos.inicializarCola();
        historialPedidos.inicializarLinkedList();
    }

    public void crearPedido()
    {
        Pedido nuevoPedido = new Pedido(0);

        colaPedidos.acolar(nuevoPedido);
    }

    private void mostrarInfoPedidos(int id, int estado)
    {
        String estadoMostrar = switch (estado) {
            case 0 -> "Pendiente";
            case 1 -> "En preparación";
            case 2 -> "Listo";
            case 3 -> "Cancelado";
            default -> "Indefinido";
        };

        System.out.printf("\n%3s - %6s", "ID", "ESTADO");
        System.out.printf("\n%3s - %6s \n", id, estadoMostrar);
    }

    // como mejora, en vez de filtrar los pedidos por "pendientes" damos la opción
    // al usuario de optar el filtro de los pedidos que desea ver. En caso de querer ver todos los pedidos
    // que están en la cola, tendrá que elegir el identificador "4".
    public void verColaPedidos(int filtroEstadoId) // complejidad temporal O(2N)
    {
        ICola copiaCola = new Cola();
        copiaCola.inicializarCola();

        while (!colaPedidos.colaVacia())
        {
            Pedido p = colaPedidos.primero();
            copiaCola.acolar(p);

            if (p.estado == filtroEstadoId || filtroEstadoId == 4)
                mostrarInfoPedidos(p.pedidoID, p.estado);

            colaPedidos.descolar();
        }

        while (!copiaCola.colaVacia())
        {
            colaPedidos.acolar(copiaCola.primero());
            copiaCola.descolar();
        }
    }
    public void modificarEstado(int id, int nuevoEstado)
    {
        ICola aux = new Cola();
        aux.inicializarCola();
        while(!colaPedidos.colaVacia()){
            Pedido p = colaPedidos.primero();
            if(p.pedidoID == id){
                if(!(nuevoEstado < p.estado))
                {
                    p.estado = nuevoEstado;
                    if(p.estado == 2 || p.estado == 3){
                        historialPedidos.add(p);
                    }

                }
            }
            if(p.estado != 3 && p.estado != 2){
                aux.acolar(p);
            }

            colaPedidos.descolar();

        }
        while(!aux.colaVacia()){
            colaPedidos.acolar(aux.primero());
            aux.descolar();
        }
    }
    public void verHistorialPedidos(){
        ILinkedList listaAux = new LinkedList();
        listaAux.inicializarLinkedList();

        while(!historialPedidos.listaVacia()){
            Pedido poppeado = historialPedidos.pop();
            mostrarInfoPedidos(poppeado.pedidoID, poppeado.estado);
            listaAux.unShift(poppeado);


        }
    }
}
