public class GestionPedidos {

    private PilaPedidos pilaPrincipal;
    private PilaPedidos pilaSecundaria;

    public GestionPedidos() {
        pilaPrincipal = new PilaPedidos();
        pilaSecundaria = new PilaPedidos();
    }

    // Guarda el pedido en la pila principal
    public void registrarPedido(Pizza pizza) {
        pilaPrincipal.push(pizza);

        // Un pedido nuevo elimina las opciones de rehacer anteriores
        pilaSecundaria = new PilaPedidos();
    }

    // Mueve el ultimo pedido a la pila secundaria
    public Pizza deshacer() {
        Pizza pizzaDeshecha = pilaPrincipal.pop();

        if (pizzaDeshecha != null) {
            pilaSecundaria.push(pizzaDeshecha);
        }

        return pizzaDeshecha;
    }

    // Devuelve el ultimo pedido deshecho a la pila principal
    public Pizza rehacer() {
        Pizza pizzaRecuperada = pilaSecundaria.pop();

        if (pizzaRecuperada != null) {
            pilaPrincipal.push(pizzaRecuperada);
        }

        return pizzaRecuperada;
    }

    // Consulta el pedido ubicado en el tope
    public Pizza obtenerPedidoActual() {
        return pilaPrincipal.peek();
    }
}
