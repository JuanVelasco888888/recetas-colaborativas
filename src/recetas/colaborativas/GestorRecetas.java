package recetas.colaborativas;
import java.util.ArrayList;
import java.util.List;

public class GestorRecetas {
    private List<receta> recetas = new ArrayList<>();
    
    public void agregarReceta(receta receta) {
        recetas.add(receta);
    }
    
    public List<receta> obtenerRecetas() {
        return recetas;
    }
}