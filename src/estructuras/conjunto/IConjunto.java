package estructuras.conjunto;

public interface IConjunto<T> {
    void inicializarConjunto();
    void agregar(T producto);
    T elegir();
    boolean conjuntoVacio();
    T sacar(String nombre);
    boolean pertenece(String nombre);
}
