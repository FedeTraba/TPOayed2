package estructuras.linkedlist;

import snippets.sistemaController.Pedido;

public interface ILinkedList {
    void inicializarLinkedList();
    void add(Pedido p); // agrega un elemento al final: pila inicializada.
    void unShift(Pedido p); // agrega un elemento al inicio: pila inicializada.
    Pedido pop(); // retorna y remueve el último elemento en la lista: lista inicializada.
    boolean listaVacia(); // lista inicializada.
}
