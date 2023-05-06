import snippets.productoController.ProductoController;

import snippets.sistemaController.SistemaController;

public class Main {
    static void creacionProductos(ProductoController pc)
    {
        pc.crearProducto("fideos", "prueba 1", 204.21);
        pc.crearProducto("fideos", "prueba 1", 504.21);
        pc.crearProducto("fideos2", "prueba 1", 34.21);
        pc.crearProducto("fideos4", "prueba 1", 104.21);
        pc.crearProducto("pepsi", "prueba 1", 1404.21);
    }

    public static void main(String[] args) {

        ProductoController pc = new ProductoController();
        creacionProductos(pc);

        pc.modificarProduto("fideos2", 424444444);

        pc.borrarProducto("fideos2");

        SistemaController sc = new SistemaController(pc.getProductos());

        sc.crearPedidoProductos("fideos, 4; fideos4, 23; fideos2, 14; pepsi, 24; fideos, 402");

        sc.verColaPedidos(4);
    }
}