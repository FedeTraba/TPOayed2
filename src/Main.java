import snippets.productoController.ProductoController;
import snippets.sistemaController.SistemaController;

public class Main {
    public static void main(String[] args) {

        ProductoController pc = new ProductoController();
        pc.crearProducto("fideos", "prueba 1", 204.21);
        pc.crearProducto("fideos", "prueba 1", 504.21);
        pc.crearProducto("fideos2", "prueba 1", 34.21);
        pc.crearProducto("fideos4", "prueba 1", 104.21);

        pc.modificarProduto("fideos2", 424444444);

        pc.borrarProducto("fideos2");

        SistemaController sc = new SistemaController();
        sc.crearPedido();
        sc.crearPedido();
        sc.crearPedido();
        sc.crearPedido();
        sc.crearPedido();
        sc.crearPedido();
        sc.crearPedido();
        sc.crearPedido();
        sc.crearPedido();
        sc.crearPedido();
        sc.crearPedido();
        sc.modificarEstado(2,1);
        sc.modificarEstado(5,3);
        sc.modificarEstado(7,3);
        sc.modificarEstado(2,0);
        sc.modificarEstado(6, 3);
        sc.modificarEstado(11, 2);
        sc.modificarEstado(2,3);
        sc.verHistorialPedidos();
    }
}