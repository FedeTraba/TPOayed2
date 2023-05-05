package snippets.sistemaController;

import estructuras.diccionario.IDiccionario;
import estructuras.diccionario.implementacion.Diccionario;

public class Pedido {
    public static int cantidadPedidos = 0;
    public int estado; // 0: "pendiente", 1: "en preparación", 2: "listo", 3: "cancelado"
    public int pedidoID;
    public IDiccionario productosEnPedido;

    public Pedido (int estado)
    {
        cantidadPedidos++;
        this.estado = estado;
        this.pedidoID = cantidadPedidos;
        productosEnPedido = new Diccionario();
        productosEnPedido.inicializarDiccionario();
    }

    public void addProducto(String nombre, int cantidad)
    {
        productosEnPedido.agregar(nombre, cantidad);
    }
}
