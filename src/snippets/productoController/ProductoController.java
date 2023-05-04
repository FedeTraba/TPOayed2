package snippets.productoController;

import estructuras.conjunto.IConjunto;
import estructuras.conjunto.implementacion.Conjunto;

public class ProductoController {

    IConjunto productos = new Conjunto();

    public ProductoController()
    {
        productos.inicializarConjunto();
    }

    public void crearProducto(String nombre, String descripcion, double precio)
    {
        productos.agregar(new Producto(nombre, descripcion, precio));
    }

    public void modificarProduto(String nombre, double precio)
    {
        Producto pro;

        if (productos.pertenece(nombre))
        {
            pro = productos.sacar(nombre);
            pro.precio = precio;
            productos.agregar(pro);
        }
    }
}
