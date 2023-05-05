package estructuras.cola.implementacion;
import estructuras.cola.ICola;
import snippets.sistemaController.Pedido;

public class Cola implements ICola {
    static class Nodo {
        Pedido info;
        Nodo sig;
    }

    Nodo primero;
    Nodo ultimo;

    public void inicializarCola() {
        primero = null;
        ultimo = null;
    }

    public void acolar(Pedido x) {
        Nodo nuevo = new Nodo();
        nuevo.info = x;
        nuevo.sig = null;

        if (ultimo != null)
            ultimo.sig = nuevo;

        ultimo = nuevo;

        if (primero == null)
            primero = ultimo;
    }

    public void descolar() {
        primero = primero.sig;
        if (primero == null)
            ultimo = null;
    }

    public boolean colavacia() {
        return (ultimo == null);
    }

    public Pedido primero() {
        return primero.info;
    }
}
