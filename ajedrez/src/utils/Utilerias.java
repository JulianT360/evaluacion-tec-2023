package utils;

import java.util.Objects;

/**
 * Clase de utilerias.
 *
 * @author Julián Tovar
 * @since 2023-03-31
 */
public class Utilerias {

    /**
     * Función para mostrar mensaje.
     * @param mensaje Mensaje a mostrar.
     */
    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void imprimirInstrucciones() {
        mostrarMensaje("----- Tablero de Ajedrez -----");
        mostrarMensaje(String.format("Descripción: Se tiene un tablero de ajedrez en donde se deben de colocar %d reinas en todo el tablero, procurando que no se ataquen entre si.", Constantes.CANTIDAD_REINAS));
        mostrarMensaje("Instrucciones: Ingresa las coordenadas de cada una de las reinas de la siguiente forma: 1,2");
        mostrarMensaje("Restricciones: Solo se pueden utilizar números del 1 al 8");
        System.out.println();
    }

    /**
     * Método para imprimir el tablero con las reinas marcadas
     * @param tablero Tablero con las reinas marcadas.
     */
    public static void imprimirTablero(String[][] tablero) {
        mostrarMensaje("-----------------------------------");
        for(int i = 0; i < 8; i++) {
            System.out.print(" | ");
            for(int j = 0; j < 8; j++) {
                System.out.print((Objects.isNull(tablero[i][j]) ? " " : tablero[i][j]) + " | ");
            }
            mostrarMensaje("\n-----------------------------------\n");
        }
    }

    public static void imprimirRespuesta(boolean esAtaque) {
        mostrarMensaje(String.format(Constantes.RESPUESTA_TABLERO_AJEDREZ,
                (esAtaque ? "SI" : "NO")));
    }
}
