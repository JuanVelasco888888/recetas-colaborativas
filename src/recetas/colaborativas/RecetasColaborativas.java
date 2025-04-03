
package recetas.colaborativas;

import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class RecetasColaborativas {

    public static void main(String[] args) {
            GestorRecetas gestor = new GestorRecetas();
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.println("\n--- Menú Recetas ---");
            System.out.println("1. Agregar receta");
            // System.out.println("2. Listar recetas");
            System.out.println("3. Eliminar receta");
            System.out.println("4. Salir");
            System.out.print("Seleccione opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch(opcion) {
                // ... casos existentes ...
                case 1:
                System.out.println("Ingrese el nombre de la receta:");
                String nombre = scanner.nextLine();
                
                System.out.println("Ingrese los ingredientes (separados por coma):");
                String[] ingredientes = scanner.nextLine().split(",");
                
                System.out.println("Ingrese las instrucciones:");
                String instrucciones = scanner.nextLine();
                
                receta nuevaReceta = new receta(nombre, ingredientes, instrucciones);
                gestor.agregarReceta(nuevaReceta);
                
                System.out.println("Receta agregada: " + nuevaReceta.getNombre());
                break;
                case 3:
                    System.out.print("Ingrese nombre de receta a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    if(gestor.eliminarReceta(nombreEliminar)) {
                        System.out.println("Receta eliminada exitosamente");
                    } else {
                        System.out.println("No se encontró la receta");
                    }
                    break;
                    
                // ... otros casos ...
            }
       
    }
    }
    }
    
