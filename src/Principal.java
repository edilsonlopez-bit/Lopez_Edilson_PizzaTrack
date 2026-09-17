import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        GestionPedidos gestion = new GestionPedidos();
        int opcion;

        // El menu se repite hasta que el usuario elija salir
        do {
            System.out.println("\n=== PIZZA TRACK ===");
            System.out.println("1. Registrar pizza");
            System.out.println("2. Deshacer pedido");
            System.out.println("3. Rehacer pedido");
            System.out.println("4. Mostrar pedido actual");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = lector.nextInt();
            lector.nextLine();

            switch (opcion) {
                case 1:
                    registrarPizza(lector, gestion);
                    break;
                case 2:
                    deshacerPedido(gestion);
                    break;
                case 3:
                    rehacerPedido(gestion);
                    break;
                case 4:
                    mostrarPedidoActual(gestion);
                    break;
                case 0:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);

        lector.close();
    }

    // Solicita los datos y registra una pizza nueva
    public static void registrarPizza(Scanner lector, GestionPedidos gestion) {
        System.out.print("Ingrese el nombre de la pizza: ");
        String nombre = lector.nextLine();
        String[] ingredientes = new String[3];

        for (int i = 0; i < ingredientes.length; i++) {
            System.out.print("Ingrese el ingrediente " + (i + 1) + ": ");
            ingredientes[i] = lector.nextLine();
        }

        Pizza pizza = new Pizza(nombre, ingredientes);
        gestion.registrarPedido(pizza);
        System.out.println("Pizza registrada correctamente");
    }

    // Deshace el ultimo pedido registrado
    public static void deshacerPedido(GestionPedidos gestion) {
        Pizza pizzaDeshecha = gestion.deshacer();

        if (pizzaDeshecha == null) {
            System.out.println("No hay pedidos para deshacer");
        } else {
            System.out.println("Pedido deshecho: " + pizzaDeshecha.getNombre());
        }
    }

    // Recupera el ultimo pedido deshecho
    public static void rehacerPedido(GestionPedidos gestion) {
        Pizza pizzaRecuperada = gestion.rehacer();

        if (pizzaRecuperada == null) {
            System.out.println("No hay pedidos para rehacer");
        } else {
            System.out.println("Pedido recuperado: " + pizzaRecuperada.getNombre());
        }
    }

    // Muestra la pizza ubicada en el tope de la pila
    public static void mostrarPedidoActual(GestionPedidos gestion) {
        Pizza pizzaActual = gestion.obtenerPedidoActual();

        if (pizzaActual == null) {
            System.out.println("No hay pedidos activos");
            return;
        }

        System.out.println("Pedido actual");
        System.out.println("Pizza: " + pizzaActual.getNombre());
        System.out.print("Ingredientes: ");

        String[] ingredientes = pizzaActual.getIngredientes();

        for (int i = 0; i < ingredientes.length; i++) {
            System.out.print(ingredientes[i]);

            if (i < ingredientes.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();
    }
}
