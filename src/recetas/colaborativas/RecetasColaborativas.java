package recetas.colaborativas;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class RecetasColaborativas {
    public static void main(String[] args) {
        GestorRecetas gestor = new GestorRecetas();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n📌 Menú:");
            System.out.println("1. Agregar receta");
            System.out.println("2. Buscar receta por nombre");
            System.out.println("3. Buscar recetas por ingrediente");
            System.out.println("4. Ver todas las recetas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea
            
            switch (opcion) {
                case 1:
                    System.out.println("\nIngrese el nombre de la receta:");
                    String nombre = scanner.nextLine();

                    System.out.println("Ingrese los ingredientes (separados por coma):");
                    String[] ingredientes = scanner.nextLine().split(",");

                    System.out.println("Ingrese las instrucciones:");
                    String instrucciones = scanner.nextLine();

                    receta nuevaReceta = new receta(nombre, ingredientes, instrucciones);
                    gestor.agregarReceta(nuevaReceta);
                    System.out.println("✅ Receta agregada: " + nuevaReceta.getNombre());
                    break;

                case 2:
                    System.out.println("\nIngrese el nombre de la receta a buscar:");
                    String nombreBusqueda = scanner.nextLine();
                    receta resultado = gestor.buscarPorNombre(nombreBusqueda);

                    if (resultado != null) {
                        System.out.println("\n✅ Receta encontrada: " + resultado.getNombre());
                        System.out.println("Ingredientes: " + String.join(", ", resultado.getIngredientes()));
                        System.out.println("Instrucciones: " + resultado.getInstrucciones());
                    } else {
                        System.out.println("❌ No se encontró ninguna receta con ese nombre.");
                    }
                    break;

                case 3:
                    System.out.println("\nIngrese un ingrediente a buscar:");
                    String ingredienteBusqueda = scanner.nextLine();
                    List<receta> recetasConIngrediente = gestor.buscarPorIngrediente(ingredienteBusqueda);

                    if (!recetasConIngrediente.isEmpty()) {
                        System.out.println("\n✅ Recetas encontradas con " + ingredienteBusqueda + ":");
                        for (receta r : recetasConIngrediente) {
                            System.out.println("- " + r.getNombre());
                        }
                    } else {
                        System.out.println("❌ No se encontraron recetas con ese ingrediente.");
                    }
                    break;

                case 4:
                    System.out.println("\n📜 Todas las recetas:");
                    List<receta> todasLasRecetas = gestor.obtenerRecetas();
                    if (todasLasRecetas.isEmpty()) {
                        System.out.println("⚠ No hay recetas guardadas.");
                    } else {
                        for (receta r : todasLasRecetas) {
                            System.out.println("- " + r.getNombre());
                        }
                    }
                    break;

                case 5:
                    salir = true;
                    System.out.println("👋 Saliendo del sistema...");
                    break;

                default:
                    System.out.println("⚠ Opción inválida. Intente de nuevo.");
            }
        }
        scanner.close();
    }
}