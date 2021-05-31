
import java.util.ArrayList;

/**
 *
 * @author jose condori
 */
public interface Estado {
    
    boolean esMeta();
    
    public ArrayList<Estado> generarSucesores();
    
    public void mostrarEstado();
    
    public boolean igual(Estado e);
    
}
