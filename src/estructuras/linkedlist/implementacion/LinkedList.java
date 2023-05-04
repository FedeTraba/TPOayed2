package estructuras.linkedlist.implementacion;

import estructuras.linkedlist.ILinkedList;
import snippets.productoController.Producto;

public class LinkedList implements ILinkedList {

    static private class Nodo {
        Producto producto;
        Nodo next;
    }

    Nodo head;

    public void inicializarLinkedList() {
        this.head = null;
    }

    public void add(Producto p) { // O(N)
        Nodo nodo = new Nodo();
        nodo.producto = p;
        nodo.next = null;

        if (head == null) {
            head = nodo;
        } else {
            Nodo aux = head;

            while (aux.next != null)
                aux = aux.next;

            aux.next = nodo;
        }
    }

    public void unShift(Producto p) {
        Nodo nodo = new Nodo();
        nodo.producto = p;

        if (head == null)
        {
            nodo.next = null;
            head = nodo;
        } else {
            nodo.next = head;
            head = nodo;
        }
    }

    /* en proceso */
    public boolean remove(Producto p) {
        return false;
    }

    public Producto pop() {
        return null;
    }

    public boolean listaVacia() {
        return (head == null);
    }
}
