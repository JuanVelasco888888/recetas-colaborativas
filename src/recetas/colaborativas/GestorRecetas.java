package recetas.colaborativas;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class GestorRecetas {
    private List<receta> recetas = new ArrayList<>();
    
    public void agregarReceta(receta receta) {
        recetas.add(receta);
    }
    
    public List<receta> obtenerRecetas() {
        return recetas;
    }

    public boolean eliminarReceta(String nombreReceta) {
        Iterator<receta> iterator = recetas.iterator();
        while(iterator.hasNext()) {
            receta r = iterator.next();
            if(r.getNombre().equalsIgnoreCase(nombreReceta)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}


