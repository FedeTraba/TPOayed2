import snippets.productoController.ProductoController;

import snippets.sistemaController.SistemaController;

public class Main {
    static void creacionProductos(ProductoController pc)
    {
        pc.crearProducto("limonada", "Jugos", 1600);
        pc.crearProducto("pepsi chica", "Gaseosa", 350.20);
        pc.crearProducto("pepsi grande", "Gaseosa", 650.20);
        pc.crearProducto("coca chica", "Gaseosa", 350.20);
        pc.crearProducto("coca grande", "Gaseosa", 650.20);

        pc.crearProducto("café", "Cafetería", 400);
        pc.crearProducto("té", "Cafetería", 400);
        pc.crearProducto("medialunas", "Cafetería", 250);
        pc.crearProducto("tostado", "Cafetería", 400);
        pc.crearProducto("tostada", "Cafetería", 100);

        pc.crearProducto("rabas", "Entrada", 2800);
        pc.crearProducto("papas fritas", "Entrada", 800);
        pc.crearProducto("empanada", "Entrada", 100);

        pc.crearProducto("milanesa con puré", "Plato principal", 1700);
        pc.crearProducto("sorrentino con bolognesa", "Plato principal", 2100);
        pc.crearProducto("caviar con sushi", "Plato principal", 50530);
        pc.crearProducto("roll de sushi", "Plato principal", 3500);
    }

    public static void main(String[] args) {
        ProductoController pc = new ProductoController();
        creacionProductos(pc);

        SistemaController sc = new SistemaController(pc.getProductos());

        sc.crearPedidoProductos("Sorrentino con bolognesa, 2; Limonada, 1; Coca grande, 2");
        sc.crearPedidoProductos("Milanesa con puré, 2; Coca grande, 1; Rabas, 1");
        sc.crearPedidoProductos("Café, 1; Tostado, 4; Empanada, 2; Milanesa con puré, 1; Pepsi grande, 4; Caviar con sushi, 3");

        sc.verColaPedidos(4);
    }
}