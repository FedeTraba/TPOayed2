package estructuras.linkedlist.implementacion;

import estructuras.linkedlist.ILinkedList;
import snippets.sistemaController.Pedido;

public class LinkedList implements ILinkedList {

    static private class Nodo {
        Pedido pedido;
        Nodo next;
    }

    Nodo head;

    public void inicializarLinkedList() {
        this.head = null;
    }

    public void add(Pedido p) { // O(N)
        Nodo nodo = new Nodo();
        nodo.pedido = p;
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
        nodo.pedido = p;

        if (head == null)
        {
            nodo.next = null;
        } else {
            nodo.next = head;
        }
        head = nodo;
    }

    /* en proceso si no se usa, borrar implementación y método de interfaz */
    public boolean remove(Pedido p) {
        if (head.pedido == p){
            head = head.next;
            return true;
        } else {
            Nodo aux = head;
            while (aux.next != null && aux.next.pedido != p ) {
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
        Nodo aux;
        aux = head;
        Pedido p;

        if(aux.next == null){
            p = aux.pedido;
            head = null;
            return p;
        }

        while(aux.next != null)
        {
            if(aux.next.next == null)
            {
                p = aux.next.pedido;
                aux.next = null;

                return p;
            }
            aux = aux.next;
        }
        return null;

    }


    public boolean listaVacia() {
        return (head == null);
    }
}
