package estructuras.conjunto.implementacion;

import estructuras.conjunto.IConjunto;
import snippets.productoController.Producto;

public class Conjunto implements IConjunto {

    static class Nodo {
        Producto producto;
        Nodo next;
    }

    Nodo head;

    public void inicializarConjunto() {
        head = null;
    }

    public void agregar(Producto producto) {
        Nodo nodo = new Nodo();
        nodo.producto = producto;
        nodo.next = null;

        if (head == null)
        {
            head = nodo;
        } else {
            if(!pertenece(producto.nombre))
            {
                nodo.next = head;
                head = nodo;
            }
        }
    }

    public Producto elegir() {
        return head.producto;
    }

    public boolean conjuntoVacio() {
        return (head == null);
    }

    public Producto sacar(String nombre) {
        Producto pro;

        if (head != null)
        {
            if(head.producto.nombre.equals(nombre))
            {
                pro = head.producto;
                head = head.next;
                return pro;
            } else {
                Nodo aux = head;

                while(aux.next != null && !aux.next.producto.nombre.equals(nombre))
                    aux = aux.next;

                if(aux.next != null)
                {
                    pro = aux.next.producto;
                    aux.next = aux.next.next;
                    return pro;
                }

            }
        }
        return null;
    }

    public boolean pertenece(String nombre) {
        Nodo aux = head;

        while (aux != null)
        {
            if (aux.producto.nombre.equals(nombre))
                return true;

            aux = aux.next;
        }

        return false;
    }
}
