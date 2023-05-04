import estructuras.linkedlist.ILinkedList;
import estructuras.linkedlist.implementacion.LinkedList;
import snippets.productoController.Producto;

public class Main {
    public static void main(String[] args) {

        ILinkedList linkedlist = new LinkedList();
        linkedlist.inicializarLinkedList();

        Producto newP1 = new Producto();
        newP1.nombre = "Producto1";
        newP1.precio = 104;

        linkedlist.unShift(newP1);

        Producto newP2 = new Producto();
        newP2.nombre = "Producto2";
        newP2.precio = 14;

        linkedlist.unShift(newP2);

        Producto newP3 = new Producto();
        newP3.nombre = "Producto3";
        newP3.precio = 11204;

        linkedlist.unShift(newP3);

        System.out.println("Hello world!");
    }
}