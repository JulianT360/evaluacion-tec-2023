package utils;

import java.util.Objects;
import java.util.Scanner;

/**
 * Clase de utilerías.
 *
 * @author Julián Tovar
 * @since 2023-03-31
 */
public class Utilerias {

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void saltoLinea() {
        System.out.println();
    }

    public static void imprimirSeparador() {
        System.out.println("-----------------------------------------");
    }

    public static void imprimirInstrucciones() {
        mostrarMensaje("----- Sudoku -----");
        mostrarMensaje("Instrucciones: Ingresar la información correspondiente al sudoku.");
    }

    public static void imprimirSudoku(int[][] sudoku) {
        mostrarMensaje("----- Sudoku Ingresado -----");
        imprimirSeparador();
        for(int i = Constantes.CERO; i < Constantes.TAMANO_SUDOKU; i++) {
            System.out.print(" |");
            for(int j = Constantes.CERO; j < Constantes.TAMANO_SUDOKU; j++) {
                if((j)%Constantes.TRES == Constantes.CERO) {
                    System.out.print("|");
                }
                System.out.print(" " + sudoku[i][j] + " |");
            }
            saltoLinea();
            imprimirSeparador();
            if((i+Constantes.UNO)%Constantes.TRES == Constantes.CERO) {
                imprimirSeparador();
            }
        }
    }

    public static void imprimirRespuesta(boolean esValido) {
        mostrarMensaje(String.format("El sudoku %s esta armado correctamente.", (esValido ? "SI" : "NO")));
    }
}
