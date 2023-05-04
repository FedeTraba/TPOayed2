package estructuras.cola;

import snippets.sistemaController.Pedido;

public interface ICola {
    void inicializarCola();
    void acolar(Pedido x);
    void descolar();
    boolean colavacia();
    Pedido primero();

}
