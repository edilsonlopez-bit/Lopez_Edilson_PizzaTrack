public class Pizza {

    private String nombre;
    private String[] ingredientes;

    // Recibe el nombre y los tres ingredientes de la pizza
    public Pizza(String nombre, String[] ingredientes) {
        if (ingredientes.length != 3) {
            throw new IllegalArgumentException("La pizza debe tener 3 ingredientes");
        }

        this.nombre = nombre;
        this.ingredientes = new String[3];

        // Copia cada ingrediente en el arreglo fijo
        for (int i = 0; i < this.ingredientes.length; i++) {
            this.ingredientes[i] = ingredientes[i];
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }
}
