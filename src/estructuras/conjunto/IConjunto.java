package estructuras.conjunto;
import snippets.productoController.Producto;

public interface IConjunto {
    void inicializarConjuto();
    void agregar(Producto x);
    Producto elegir();
    boolean conjuntoVacio();
    void sacar(Producto x);
    boolean pertenece(Producto x);

}
