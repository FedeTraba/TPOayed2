package estructuras.conjunto;
import snippets.productoController.Producto;

public interface IConjunto {
    void inicializarConjunto();
    void agregar(Producto producto);
    Producto elegir();
    boolean conjuntoVacio();
    Producto sacar(String nombre);
    boolean pertenece(String nombre);
}
