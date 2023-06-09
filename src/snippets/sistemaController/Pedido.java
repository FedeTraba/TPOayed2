package snippets.sistemaController;

import estructuras.diccionario.IDiccionario;
import estructuras.diccionario.implementacion.Diccionario;

public class Pedido {
    public static int cantidadPedidos = 0;
    public int estado; // 0: "pendiente", 1: "en preparación", 2: "listo", 3: "cancelado"
    public int pedidoID;
    public IDiccionario productosEnPedido = new Diccionario();

    public Pedido (int estado)
    {
        this.estado = estado;
        this.pedidoID = cantidadPedidos;
        this.productosEnPedido.inicializarDiccionario();

        cantidadPedidos++;
    }

    public void addProducto(String nombre, int cantidad) // O(N)
    {
        productosEnPedido.agregar(nombre, cantidad);
    }
}
