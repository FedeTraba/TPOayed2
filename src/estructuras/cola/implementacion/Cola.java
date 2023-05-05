package estructuras.cola.implementacion;
import estructuras.cola.ICola;
import snippets.sistemaController.Pedido;

public class Cola implements ICola {
    static private class Nodo {
        Pedido pedido;
        Nodo next;
    }

    Nodo head;
    Nodo end;

    public void inicializarCola() {
        head = null;
        end = null;
    }

    public void acolar(Pedido pedido) {
        Nodo nodo = new Nodo();
        nodo.pedido = pedido;
        nodo.next = null;

        if (end != null)
            end.next = nodo;

        end = nodo;

        if (head == null)
            head = end;
    }

    public void descolar() {
        head = head.next;
    }

    public boolean colaVacia() {
        return (head == null);
    }

    public Pedido primero() {
        return head.pedido;
    }
}
