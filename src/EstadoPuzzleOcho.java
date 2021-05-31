
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Jose Condori
 * @version 25 may. 2021 17:49:29
 */
public class EstadoPuzzleOcho implements Estado {

    private final int TAM_PUZZLE = 9;
    private final int[] META = {1, 2, 3, 8, 0, 4, 7, 6, 5};
    private int[] tableroActual;

    public EstadoPuzzleOcho(int[] tablero) {
        this.tableroActual = tablero;
    }

    public int[] getTableroActual() {
        return tableroActual;
    }

    private int getEspacio() {
        int indiceEspacio = -1;

        for (int i = 0; i < TAM_PUZZLE; i++) {
            if (tableroActual[i] == 0) {
                indiceEspacio = i;
            }
        }
        return indiceEspacio;
    }

    @Override
    public boolean esMeta() {
        if (Arrays.equals(tableroActual, META)) {
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Estado> generarSucesores() {
        ArrayList<Estado> sucesores = new ArrayList<>();
        int espacio = getEspacio();

        switch (espacio) {
            case 0:
                sucesores.add(new EstadoPuzzleOcho(mover(espacio, 'R')));
                sucesores.add(new EstadoPuzzleOcho(mover(espacio, 'D')));
                break;
            case 1:
                sucesores.add(new EstadoPuzzleOcho(mover(espacio, 'L')));
                sucesores.add(new EstadoPuzzleOcho(mover(espacio, 'R')));
                sucesores.add(new EstadoPuzzleOcho(mover(espacio, 'D')));
                break;
            case 2:
                sucesores.add(new EstadoPuzzleOcho(mover(espacio, 'L')));
                sucesores.add(new EstadoPuzzleOcho(mover(espacio, 'D')));
                break;
            case 3:
                sucesores.add(new EstadoPuzzleOcho(mover(espacio, 'R')));
                sucesores.add(new EstadoPuzzleOcho(mover(espacio, 'U')));
                sucesores.add(new EstadoPuzzleOcho(mover(espacio, 'D')));
                break;
            case 4:
                sucesores.add(new EstadoPuzzleOcho(mover(espacio, 'L')));
                sucesores.add(new EstadoPuzzleOcho(mover(espacio, 'R')));
                sucesores.add(new EstadoPuzzleOcho(mover(espacio, 'U')));
                sucesores.add(new EstadoPuzzleOcho(mover(espacio, 'D')));
                break;
            case 5:
                sucesores.add(new EstadoPuzzleOcho(mover(espacio, 'L')));
                sucesores.add(new EstadoPuzzleOcho(mover(espacio, 'U')));
                sucesores.add(new EstadoPuzzleOcho(mover(espacio, 'D')));
                break;
            case 6:
                sucesores.add(new EstadoPuzzleOcho(mover(espacio, 'R')));
                sucesores.add(new EstadoPuzzleOcho(mover(espacio, 'U')));
                sucesores.add(new EstadoPuzzleOcho(mover(espacio, 'D')));
                break;
            case 7:
                sucesores.add(new EstadoPuzzleOcho(mover(espacio, 'L')));
                sucesores.add(new EstadoPuzzleOcho(mover(espacio, 'R')));
                sucesores.add(new EstadoPuzzleOcho(mover(espacio, 'U')));
                break;
            case 8:
                sucesores.add(new EstadoPuzzleOcho(mover(espacio, 'L')));
                sucesores.add(new EstadoPuzzleOcho(mover(espacio, 'U')));
                break;
        }
        return sucesores;
    }

    private int[] mover(int espacio, char direccion) {
        int[] tableroSucesor = Arrays.copyOf(tableroActual, tableroActual.length);
        int cambio = tableroActual[espacio];

        // Operadores
        switch (direccion) {
            // 1) Mover espacio a la izquierda
            case 'L':
                tableroSucesor[espacio] = tableroActual[espacio - 1];
                tableroSucesor[espacio - 1] = cambio;
                break;
            // 2) Mover espacio a la derecha
            case 'R':
                tableroSucesor[espacio] = tableroActual[espacio + 1];
                tableroSucesor[espacio + 1] = cambio;
                break;
            // 3) Mover espacio arriba
            case 'U':
                tableroSucesor[espacio] = tableroActual[espacio - 3];
                tableroSucesor[espacio - 3] = cambio;
                break;
            // 4) Mover espacio abajo
            case 'D':
                tableroSucesor[espacio] = tableroActual[espacio + 3];
                tableroSucesor[espacio + 3] = cambio;
                break;
        }
        return tableroSucesor;
    }

    @Override
    public void mostrarEstado() {
        System.out.println(tableroActual[0] + " | " + tableroActual[1] + " | " + tableroActual[2]);
        System.out.println(tableroActual[3] + " | " + tableroActual[4] + " | " + tableroActual[5]);
        System.out.println(tableroActual[6] + " | " + tableroActual[7] + " | " + tableroActual[8]);
    }

    @Override
    public boolean igual(Estado e) {
        if (Arrays.equals(tableroActual, ((EstadoPuzzleOcho) e).getTableroActual())) {
            return true;
        }
        return false;
    }

}
