
package recetas.colaborativas;

import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class RecetasColaborativas {

    while (true) {
            System.out.println("\nMenú de Recetas");
            System.out.println("1. Agregar nueva receta");
            System.out.println("2. Listar recetas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre de la receta:");
                    String nombre = scanner.nextLine();
                    
                    System.out.println("Ingrese los ingredientes (separados por coma):");
                    String[] ingredientes = scanner.nextLine().split(",");
                    
                    System.out.println("Ingrese las instrucciones:");
                    String instrucciones = scanner.nextLine();
                    
                    Receta nuevaReceta = new Receta(nombre, ingredientes, instrucciones);
                    gestor.agregarReceta(nuevaReceta);
                    
                    System.out.println("✅ Receta agregada: " + nuevaReceta.getNombre());
                    break;
                
                case 2:
                    gestor.listarRecetas();
                    break;
                
                case 3:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                
                default:
                    System.out.println("❌ Opción no válida, intente de nuevo.");
            }
        }

    }
    
