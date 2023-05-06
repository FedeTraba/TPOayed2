package snippets.productoController;

import estructuras.conjunto.IConjunto;
import estructuras.conjunto.implementacion.Conjunto;

public class ProductoController {

    IConjunto<Producto> productos = new Conjunto();

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
        Producto productoAux;

        if (productos.pertenece(nombre))
        {
            productoAux = productos.sacar(nombre);
            productoAux.precio = precio;
            productos.agregar(productoAux);
        }
    }

    public void borrarProducto(String nombre)
    {
        productos.sacar(nombre);
    }

    public IConjunto<Producto> getProductos() {
        return productos;
    }
}
