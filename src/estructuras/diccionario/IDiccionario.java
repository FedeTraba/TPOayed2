package estructuras.diccionario;

import estructuras.conjunto.implementacion.ConjuntoStr;

public interface IDiccionario {
    void inicializarDiccionario ();
    void agregar(String nombre, int cantidad);
    void eliminar(String nombre);
    int recuperar(String nombre);

    ConjuntoStr identificadores();
}
