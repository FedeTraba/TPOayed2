package snippets.productoController;

import estructuras.conjunto.IConjunto;
import estructuras.conjunto.implementacion.Conjunto;

import java.io.File;
import java.util.Scanner;

public class ProductoController {

    IConjunto<Producto> productos = new Conjunto();

    public ProductoController() //Operación de tiempo constante (O(1))
    {
        productos.inicializarConjunto();
        cargarProductos();
    }


    public void crearProducto(String nombre, String descripcion, double precio) // Operación de tiempo constante (O(1))
    {
        productos.agregar(new Producto(nombre.toLowerCase(), descripcion, precio));
    }

    public void modificarProduto(String nombre, double precio) //Operación lineal (O(n))
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
    } //Operación lineal (O(n))

    void cargarProductos() // Operación lineal (O(m))
    {
        String currentDirectory = System.getProperty("user.dir");
        try {
            File file = new File(currentDirectory + "\\src\\productos.txt");
            Scanner reader = new Scanner(file);
            boolean head = true;

            while (reader.hasNextLine())
            {
                if (head)
                {
                    head = false;
                    reader.nextLine();
                }
                else
                {
                    String line = reader.nextLine();
                    String[] lineaProcesada = line.strip().split(";");
                    crearProducto(lineaProcesada[0], lineaProcesada[1], Double.parseDouble(lineaProcesada[2]));
                }
            }

        } catch (Exception e) { //Operación de tiempo constante (O(1))
            e.printStackTrace();
        }
    }

    public IConjunto<Producto> getProductos()
    {
        return productos;
    }
}
