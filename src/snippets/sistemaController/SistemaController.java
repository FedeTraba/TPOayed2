package snippets.sistemaController;

import estructuras.cola.ICola;
import estructuras.cola.implementacion.Cola;

public class SistemaController {
    ICola listaPedidos = new Cola();

    public SistemaController()
    {
        listaPedidos.inicializarCola();
    }


}
