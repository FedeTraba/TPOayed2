package estructuras.linkedlist;

import snippets.productoController.Producto;

public interface ILinkedList {
    void inicializarLinkedList();
    void add(Producto p); // agrega un elemento al final: pila inicializada.
    void unShift(Producto p); // agrega un elemento al inicio: pila inicializada.
    boolean remove(Producto p); // remueve un elemento que le pasemos como parámetro.
    Producto pop(); // retorna y remueve el último elemento en la lista: lista inicializada.
    boolean listaVacia(); // lista inicializada.
}
