package estructuras.diccionario.implementacion;

import estructuras.conjunto.implementacion.Conjunto;
import estructuras.diccionario.IDiccionario;
import snippets.productoController.Producto;

public class Diccionario implements IDiccionario {
    //Falta ver si va un array de productos (o linkedlist)
    private class NodoClave{
        int clave;
        Producto productos;
        NodoClave sig;
    }
    private int id;
    private NodoClave primero;

    private NodoClave Clave2NodoClave(int id){
        NodoClave aux = primero;
        while(aux != null && aux.clave != id){
            aux = aux.sig;
        }
        return aux;

    }
    public void inicializarDiccionario() {
        id = 0;
        primero = null;
    }

    //modificar para que use la variable de clase ID
    public void agregar(int id, Producto lista) {
        NodoClave nodo = Clave2NodoClave(id);
        if(nodo == null){
            nodo = new NodoClave();
            nodo.clave = id;
            nodo.sig = primero;
            primero = nodo;
        }
        nodo.productos = lista;
        id++;
    }


    public void eliminar(int id) {
        if(primero != null){
            if(primero.clave == id){
                primero = primero.sig;
            } else{
                NodoClave aux = primero;
                while(aux.sig != null && aux.sig.clave != id){
                    aux = aux.sig;
                }
                if(aux.sig != null){
                    aux.sig = aux.sig.sig;
                }
            }
        }
    }


    public Producto recuperar(int id) {
        NodoClave nodo = Clave2NodoClave(id);
        return nodo.productos;
    }


    public Conjunto identificadores() {
        Conjunto claves = new Conjunto();
        claves.inicializarConjunto();
        NodoClave aux = primero;
        while(aux != null){
            claves.agregar(aux.productos);
            aux = aux.sig;
        }
        return claves;
    }
}
