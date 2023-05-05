package snippets.sistemaController;

import estructuras.diccionario.IDiccionario;
import estructuras.diccionario.implementacion.Diccionario;

public class Pedido {
    public static int pedidoID = 0;
    public int estado; // 0: "pendiente", 1: "en preparación", 2: "listo", 3: "cancelado"
    IDiccionario productosEnPedido;

    public Pedido (int estado)
    {
        pedidoID++;
        this.estado = estado;
        productosEnPedido = new Diccionario();
        productosEnPedido.inicializarDiccionario();
    }

    public int getPedidoID() {
        return pedidoID;
    }

    public void addProducto(String nombre, int cantidad)
    {
        productosEnPedido.agregar(nombre, cantidad);
    }
}
