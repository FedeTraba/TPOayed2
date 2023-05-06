package estructuras.diccionario.implementacion;

import estructuras.conjunto.implementacion.ConjuntoStr;
import estructuras.diccionario.IDiccionario;

public class Diccionario implements IDiccionario {

    static private class NodoClave{
        String nombre;
        int cantidad;
        NodoClave sig;
    }

    private NodoClave primero;

    private NodoClave Clave2NodoClave(String nombre){
        NodoClave aux = primero;
        while(aux != null && !aux.nombre.equals(nombre)){
            aux = aux.sig;
        }
        return aux;

    }
    public void inicializarDiccionario() {
        primero = null;
    }

    //modificar para que use la variable de clase ID
    public void agregar(String nombre, int cantidad) {
        NodoClave nodo = Clave2NodoClave(nombre);
        if(nodo == null){
            nodo = new NodoClave();
            nodo.nombre = nombre;
            nodo.cantidad = cantidad;
            nodo.sig = primero;
            primero = nodo;
        } else {
            nodo.cantidad += 1;
        }
    }


    public void eliminar(String nombre) {
        if(primero != null){
            if(primero.nombre.equals(nombre)){
                primero = primero.sig;
            } else{
                NodoClave aux = primero;
                while(aux.sig != null && !aux.sig.nombre.equals(nombre)){
                    aux = aux.sig;
                }
                if(aux.sig != null){
                    aux.sig = aux.sig.sig;
                }
            }
        }
    }


    public int recuperar(String nombre) {
        NodoClave nodo = Clave2NodoClave(nombre);
        return nodo.cantidad;
    }


    public ConjuntoStr identificadores() {
        ConjuntoStr claves = new ConjuntoStr();
        claves.inicializarConjunto();
        NodoClave aux = primero;

        while(aux != null){
            claves.agregar(aux.nombre);
            aux = aux.sig;
        }

        return claves;
    }
}
