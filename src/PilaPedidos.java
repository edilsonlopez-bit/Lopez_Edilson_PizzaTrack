public class PilaPedidos {

    private Nodo tope;

    public PilaPedidos() {
        tope = null;
    }

    // Agrega una pizza en el tope de la pila
    public void push(Pizza pizza) {
        Nodo nuevoNodo = new Nodo(pizza);

        // El nuevo nodo apunta al tope anterior
        nuevoNodo.setSiguiente(tope);

        // El nuevo nodo se convierte en el tope
        tope = nuevoNodo;
    }

    // Retira y devuelve la pizza ubicada en el tope
    public Pizza pop() {
        if (isEmpty()) {
            return null;
        }

        Pizza pizzaRetirada = tope.getPizza();

        // El siguiente nodo pasa a ser el nuevo tope
        tope = tope.getSiguiente();

        return pizzaRetirada;
    }

    // Devuelve la pizza del tope sin retirarla
    public Pizza peek() {
        if (isEmpty()) {
            return null;
        }

        return tope.getPizza();
    }

    // Comprueba si la pila no tiene pedidos
    public boolean isEmpty() {
        return tope == null;
    }
}
