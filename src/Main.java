import snippets.productoController.ProductoController;

import snippets.sistemaController.SistemaController;

public class Main {
    public static void main(String[] args) {
        ProductoController pc = new ProductoController();
        SistemaController sc = new SistemaController(pc.getProductos());

        sc.crearPedidoProductos("rabas, 3; empanada, 3");
        sc.crearPedidoProductos("Café, 1; Tostado, 4; Empanada, 2; Milanesa con puré, 1; Pepsi grande, 4; Caviar con sushi, 3");
        sc.crearPedidoProductos("Café, 1; Tostado, 4; Empanada, 2; Milanesa con puré, 1; Pepsi grande, 4; Caviar con sushi, 3");
        sc.crearPedidoProductos("Café, 1; Tostado, 4; Empanada, 2; Milanesa con puré, 1; Pepsi grande, 4; Caviar con sushi, 3");

        sc.modificarEstado(1, 3);
        sc.modificarEstado(0, 2);

        sc.verColaPedidos(4);
        sc.verHistorialPedidos();
    }
}
