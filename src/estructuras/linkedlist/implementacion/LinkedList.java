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
    } //Operación de tiempo constante (O(1))

    public void add(Pedido p) { // Operación lineal (O(N))
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

    public void unShift(Pedido p) { //Operación de tiempo constante (O(1))
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

    public Pedido pop() { //Operación lineal (O(N))
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
    } //Operación de tiempo constante (O(1))
}
