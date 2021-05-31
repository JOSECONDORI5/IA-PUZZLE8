
import java.util.ArrayList;


/**
 *
 * @author Jose Condori
 * @version 25 may. 2021 18:22:41
 */
public class PruebaEstadoPuzzle8 {
    public static void main(String[] args) {
        int[] a = {5, 4, 0, 6, 1, 8, 7, 3, 2};
        EstadoPuzzleOcho tab01 = new EstadoPuzzleOcho(a);
        
        int[] b = {5, 0, 4, 6, 1, 8, 7, 3, 2};
        EstadoPuzzleOcho tab02 = new EstadoPuzzleOcho(b);     
        
        int[] c = {1, 2, 3, 8, 0, 4, 7, 6, 5};
        EstadoPuzzleOcho tab04 = new EstadoPuzzleOcho(c);

//        System.out.println("Es meta tab01: " + tab01.esMeta());
//        System.out.println("Es meta tab04: " + tab04.esMeta());

        tab04.mostrarEstado();
        System.out.println("");
        mostrarSucesores(tab04);
    }
    
    public static void mostrarSucesores(Estado tablero){
        for(Estado sucesor: tablero.generarSucesores()){
            sucesor.mostrarEstado();
            System.out.println("=========");
        }
    }
}
