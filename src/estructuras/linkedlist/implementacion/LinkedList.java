package estructuras.linkedlist.implementacion;

import estructuras.linkedlist.ILinkedList;
import snippets.sistemaController.Pedido;

public class LinkedList implements ILinkedList {

    static private class Nodo {
        Pedido producto;
        Nodo next;
    }

    Nodo head;

    public void inicializarLinkedList() {
        this.head = null;
    }

    public void add(Pedido p) { // O(N)
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

    public void unShift(Pedido p) {
        Nodo nodo = new Nodo();
        nodo.producto = p;

        if (head == null)
        {
            nodo.next = null;
        } else {
            nodo.next = head;
        }
        head = nodo;
    }

    /* en proceso */
    public boolean remove(Pedido p) {
        if (head.producto == p){
            head = head.next;
            return true;
        } else {
            Nodo aux = head;
            while (aux.next != null && aux.next.producto != p ) {
                aux = aux.next;
            }
            if (aux.next != null) {
                aux.next = aux.next.next;
                return true;
            }
        }
        return false;
    }

    public Pedido pop() {
        Pedido prod;
        if (head.next == null) {
            prod = head.producto;
            head = null;
        } else {
            Nodo aux = head;
            while(aux.next.next.next != null) {
                aux = aux.next;
            }
            prod = aux.next.next.producto;
            aux.next = null;
        }
        return prod;
    }

    public boolean listaVacia() {
        return (head == null);
    }
}
