package estructuras.diccionario;

import estructuras.conjunto.implementacion.Conjunto;
import snippets.productoController.Producto;

public interface IDiccionario {
    void inicializarDiccionario ();
    void agregar(String nombre, int cantidad);
    void eliminar(String nombre);
    int recuperar(String nombre);

    Conjunto identificadores();
}
