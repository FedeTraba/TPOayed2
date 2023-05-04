package estructuras.diccionario;

import estructuras.conjunto.implementacion.Conjunto;
import snippets.productoController.Producto;

public interface IDiccionario {
    void inicializarDiccionario ();
    void agregar(int id, Producto lista);
    void eliminar(int id);
    Producto recuperar(int id);

    Conjunto identificadores();
}
