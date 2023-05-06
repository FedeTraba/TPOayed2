import snippets.productoController.ProductoController;

import snippets.sistemaController.SistemaController;

public class Main {
    public static void main(String[] args) {

        ProductoController pc = new ProductoController();
        pc.crearProducto("fideos", "prueba 1", 204.21);
        pc.crearProducto("fideos", "prueba 1", 504.21);
        pc.crearProducto("fideos2", "prueba 1", 34.21);
        pc.crearProducto("fideos4", "prueba 1", 104.21);
        pc.crearProducto("pepsi", "prueba 1", 1404.21);

        pc.modificarProduto("fideos2", 424444444);

        pc.borrarProducto("fideos2");

        SistemaController sc = new SistemaController(pc.getProductos());

        sc.crearPedidoProductos("fideos, 4; fideos4, 23; pepsi, 24");
        //sc.crearPedidoProductos("fideos4, 2; fideos2, 3");

        sc.verColaPedidos(4);
    }
}