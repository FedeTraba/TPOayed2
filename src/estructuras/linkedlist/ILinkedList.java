package estructuras.linkedlist;

import snippets.sistemaController.Pedido;

public interface ILinkedList {
    void inicializarLinkedList();
    void add(Pedido p); // agrega un elemento al final: pila inicializada.
    void unShift(Pedido p); // agrega un elemento al inicio: pila inicializada.
    boolean remove(Pedido p); // remueve un elemento que le pasemos como parámetro.
    Pedido pop(); // retorna y remueve el último elemento en la lista: lista inicializada.
    boolean listaVacia(); // lista inicializada.
}
