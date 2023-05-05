import snippets.productoController.ProductoController;

public class Main {
    public static void main(String[] args) {

        ProductoController pc = new ProductoController();
        pc.crearProducto("fideos", "prueba 1", 204.21);
        pc.crearProducto("fideos", "prueba 1", 504.21);
        pc.crearProducto("fideos2", "prueba 1", 34.21);
        pc.crearProducto("fideos4", "prueba 1", 104.21);

        pc.modificarProduto("fideos2", 424444444);

        pc.borrarProducto("fideos2");
        System.out.println("sad");
    }
}