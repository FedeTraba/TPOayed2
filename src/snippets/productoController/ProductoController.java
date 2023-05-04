package snippets.productoController;
package estructuras.conjunto.implementacion.Conjunto;

public class ProductoController {

    Conjunto productos = new Conjunto();

    void crearProducto(String nombre, String desc, double precio)
    {    
        productos.agregar(new Producto(nombre, desc, precio));  
    }
    
}
