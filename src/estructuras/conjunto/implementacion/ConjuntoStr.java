package estructuras.conjunto.implementacion;

import estructuras.conjunto.IConjunto;

public class ConjuntoStr implements IConjunto<String> {
    private static class Nodo {
        String clave;
        Nodo next;
    }

    Nodo head;

    public void inicializarConjunto() {
        head = null;
    } //Operación de tiempo constante (O(1))

    public void agregar(String clave) { //Operación lineal (O(n)).
        Nodo nodo = new Nodo();
        nodo.clave = clave;
        nodo.next = null;

        if (head == null)
        {
            head = nodo;
        } else {
            if(!pertenece(clave))
            {
                nodo.next = head;
                head = nodo;
            }
        }
    }

    public String elegir() {
        return head.clave;
    } //Operación de tiempo constante (O(1)).

    public boolean conjuntoVacio() {
        return (head == null);
    } // Operación de tiempo constante (O(1)).

    public String sacar(String nombre) { //Operación lineal (O(n)).
        String pro;

        if (head != null)
        {
            if(head.clave.equals(nombre))
            {
                pro = head.clave;
                head = head.next;
                return pro;
            } else {
                Nodo aux = head;

                while(aux.next != null && !aux.clave.equals(nombre))
                    aux = aux.next;

                if(aux.next != null)
                {
                    pro = aux.next.clave;
                    aux.next = aux.next.next;
                    return pro;
                }

            }
        }
        return null;
    }

    public boolean pertenece(String nombre) { //Operación lineal (O(n)).
        Nodo aux = head;

        while (aux != null)
        {
            if (aux.clave.equals(nombre))
                return true;

            aux = aux.next;
        }

        return false;
    }
}
