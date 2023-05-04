package estructuras.diccionario.implementacion;

import estructuras.conjunto.implementacion.Conjunto;
import estructuras.diccionario.IDiccionario;
import snippets.productoController.Producto;

public class Diccionario implements IDiccionario {
    //Falta ver si va un array de productos (o linkedlist)
    private class NodoClave{
        String nombre;
        int cantidad;
        NodoClave sig;
    }
    private int id;
    private NodoClave primero;

    private NodoClave Clave2NodoClave(String nombre){
        NodoClave aux = primero;
        while(aux != null && !aux.nombre.equals(nombre)){
            aux = aux.sig;
        }
        return aux;

    }
    public void inicializarDiccionario() {
        id = 0;
        primero = null;
    }

    //modificar para que use la variable de clase ID
    public void agregar(String nombre, int cantidad) {
        NodoClave nodo = Clave2NodoClave(id);
        if(nodo == null){
            nodo = new NodoClave();
            nodo.nombre = nombre;
            nodo.sig = primero;
            primero = nodo;
        }
        nodo.cantidad += 1;
        id++;
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


    public Conjunto identificadores() {
        Conjunto claves = new Conjunto();
        claves.inicializarConjunto();
        NodoClave aux = primero;
        while(aux != null){
            claves.agregar(aux.nombre);
            aux = aux.sig;
        }
        return claves;
    }
}
