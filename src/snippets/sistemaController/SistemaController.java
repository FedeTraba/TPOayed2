package snippets.sistemaController;

import estructuras.cola.ICola;
import estructuras.cola.implementacion.Cola;
import estructuras.linkedlist.ILinkedList;
import estructuras.linkedlist.implementacion.LinkedList;

public class SistemaController {
    ICola listaPedidos = new Cola();
    ILinkedList historialPedidos = new LinkedList();

    public SistemaController()
    {
        listaPedidos.inicializarCola();
        historialPedidos.inicializarLinkedList();
    }

    public void crearPedido()
    {
        Pedido nuevoPedido = new Pedido(0);

        listaPedidos.acolar(nuevoPedido);
        historialPedidos.add(nuevoPedido);
    }

    public void cancelarPedido()
    {

    }

}
