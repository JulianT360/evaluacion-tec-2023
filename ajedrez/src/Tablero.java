import utils.Constantes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utils.Utilerias.mostrarMensaje;

/**
 * Clase tablero.
 *
 * @author Julián Tovar
 * @since 2023-03-31
 */
public class Tablero {

    private final String[][] tablero;
    private final List<int[]> reinas;

    public Tablero() {
        this.tablero = new String[8][8];
        this.reinas = new ArrayList<>();
    }

    /**
     * Método get para tablero.
     * @return String[][].
     */
    public String[][] getTablero() {
        return this.tablero;
    }

    /**
     * Método para leer las ubicaciones de las reinas.
     */
    public void leerUbicacionesReinas() {
        int[] coordenadas;
        for(int i = 1; i <= Constantes.CANTIDAD_REINAS; i++) {
            mostrarMensaje(String.format("Ingrese las coordenadas para la reina %d: ", i));
            coordenadas = leerCoordenadas();
            reinas.add(coordenadas);
        }
    }

    /**
     * Se leen las coordenadas introducidas
     * @return Arreglo con las coordenadas leidas.
     */
    private int[] leerCoordenadas() {
        Scanner lector = new Scanner(System.in);

        String posicionReina = lector.nextLine();
        if(posicionReina.isEmpty()) {
            mostrarMensaje(Constantes.ERROR_DATOS_NO_VALIDOS);
            System.exit(Constantes.CERO);
        }

        String[] coordenadas = posicionReina.split(",");
        if(coordenadas.length != 2
                || coordenadas[Constantes.CERO].isEmpty()
                || coordenadas[Constantes.UNO].isEmpty()) {
            mostrarMensaje(Constantes.ERROR_DATOS_NO_VALIDOS);
            System.exit(Constantes.CERO);
        }

        int x = Integer.parseInt(coordenadas[Constantes.CERO]);
        int y = Integer.parseInt(coordenadas[Constantes.UNO]);

        if(x == Constantes.CERO || y == Constantes.CERO) {
            mostrarMensaje(Constantes.ERROR_DATOS_NO_VALIDOS);
            System.exit(Constantes.CERO);
        }

        x = x - Constantes.UNO;
        y = y - Constantes.UNO;

        int[] coordenadasReina = new int[]{x, y};
        if (coordenadaReinaEsValida(coordenadasReina)) {
            mostrarMensaje(Constantes.ERROR_COORDENADA_YA_UTILIZADA);
            System.exit(Constantes.CERO);
        }

        return coordenadasReina;
    }

    /**
     * Método para ubicar las reinas en un tablero.
     */
    public void ubicarReinasEnTablero() {
        for(int[] coordenadas : reinas) {
            tablero[coordenadas[Constantes.CERO]][coordenadas[Constantes.UNO]] = "X";
        }
    }

    /**
     * Válida si la coordenada ingresada ya pertenece a una reina registrada.
     * @param coordenadas int[] de coordenadas x,y
     * @return True si la coordenada ya esta siendo utilizada, false si no.
     */
    public boolean coordenadaReinaEsValida(int[] coordenadas) {
        for(int[] reina : reinas) {
            if(reina[Constantes.CERO] == coordenadas[Constantes.CERO]
                    && reina[Constantes.UNO] == coordenadas[Constantes.UNO]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método para validar los ataques entre reinas.
     * @return True si hay ataques entre las reinas y false si no hay ningún ataque.
     */
    public boolean validarAtaques() {
        for(int[] reina : reinas) {
            int x = reina[Constantes.CERO];
            int y = reina[Constantes.UNO];

            // Validar eje x
            for(int i = Constantes.CERO; i < 8; i++) {
                if(i != x && Constantes.MARCA_REINA.equalsIgnoreCase(tablero[i][y])) {
                    return true;
                }
            }

            // Validar eje y
            for(int j = Constantes.CERO; j < 8; j++) {
                if(j != y && Constantes.MARCA_REINA.equalsIgnoreCase(tablero[x][j])) {
                    return true;
                }
            }

            int i = x;
            int j = y;

            while(i < Constantes.LIMITE_TABLERO && j < Constantes.LIMITE_TABLERO) {
                i++;
                j++;
                if(Constantes.MARCA_REINA.equalsIgnoreCase(tablero[i][j])) {
                    return true;
                }
            }

            i = x;
            j = y;
            while(i < Constantes.LIMITE_TABLERO && j > Constantes.CERO) {
                i++;
                j--;
                if(Constantes.MARCA_REINA.equalsIgnoreCase(tablero[i][j])) {
                    return true;
                }
            }

            i = x;
            j = y;
            while(i > Constantes.CERO && j < Constantes.LIMITE_TABLERO) {
                i--;
                j++;
                if(Constantes.MARCA_REINA.equalsIgnoreCase(tablero[i][j])) {
                    return true;
                }
            }

            i = x;
            j = y;
            while(i > Constantes.CERO && j > Constantes.CERO) {
                i--;
                j--;
                if(Constantes.MARCA_REINA.equalsIgnoreCase(tablero[i][j])) {
                    return true;
                }
            }
        }
        return false;
    }

}
