package estructuras.conjunto.implementacion;

import estructuras.conjunto.IConjunto;
import snippets.productoController.Producto;

public class Conjunto implements IConjunto {
    private class Nodo{
       Producto info;
       Nodo sig;
    }
    private Nodo c;


    public void inicializarConjunto() {
        c = null;

    }


    public void agregar(Producto x) {
        if (!this.pertenece(x)) {
            Nodo nuevo = new Nodo();
            nuevo.info = x;
            nuevo.sig = c;
            c = nuevo;
        }

    }


    public Producto elegir() {
        return c.info;
    }


    public boolean conjuntoVacio() {
        return c == null;
    }


    public void sacar(Producto x) {
    if (c !=null) {
        if(c.info == x){
            c = c.sig;
        } else {
            Nodo aux = c;
            while (aux.sig != null && aux.sig.info != x)
                aux = aux.sig;
            if (aux.sig != null) {
                aux.sig = aux.sig.sig;
            }
        }
    }
    }

    public boolean pertenece(Producto x) {
        Nodo aux = c;
        while (aux != null && aux.info != x)
            aux = aux.sig;
        return (aux != null);
    }
}
