import utils.Constantes;

import java.util.Objects;
import java.util.Scanner;

import static utils.Utilerias.imprimirInstrucciones;
import static utils.Utilerias.imprimirRespuesta;
import static utils.Utilerias.imprimirSeparador;
import static utils.Utilerias.imprimirSudoku;
import static utils.Utilerias.mostrarMensaje;
import static utils.Utilerias.saltoLinea;

public class Sudoku {

    public static void main(String[] args) {
        imprimirInstrucciones();
        int[][] sudoku = leerDatos();
        imprimirSudoku(sudoku);
        imprimirRespuesta(validarArray(sudoku));
    }

    /**
     * Lee los datos para llenar el arreglo del sudoku.
     * @return int[][] Genera un sudoku.
     */
    private static int[][] leerDatos() {
        int contadorX = Constantes.CERO;
        int contadorY = Constantes.CERO;

        int[][] cuadrante;

        int[][] sudoku = new int[Constantes.TAMANO_SUDOKU][Constantes.TAMANO_SUDOKU];

        for(int i = Constantes.CERO; i < Constantes.CANTIDAD_CUADRANTES; i++) {
            saltoLinea();
            imprimirSeparador();
            mostrarMensaje(String.format("Ingrese la información del cuadrante # %d", (i+1)));
            saltoLinea();

            cuadrante = leerCuadrante();

            for(int j = Constantes.CERO; j < Constantes.TRES; j++) {
                for(int k = Constantes.CERO; k< Constantes.TRES; k++) {
                    sudoku[j+contadorY][k+contadorX] = cuadrante[j][k];
                }
            }

            contadorX = contadorX + Constantes.TRES;

            if((i+1) % Constantes.TRES == 0) {
                contadorX = Constantes.CERO;
                contadorY = contadorY + Constantes.TRES;
            }
        }

        return sudoku;
    }

    /**
     * Método para leer un cuadrante de sudoku.
     * @return int[][] con valores númericos de un cuadrante.
     */
    private static int[][] leerCuadrante() {
        int[][] cuadrante = new int[Constantes.TRES][Constantes.TRES];
        for(int i = Constantes.CERO; i < Constantes.TRES; i++) {
            mostrarMensaje(String.format("Ingrese la información de la fila %d en formato 1,2,3: ", (i+1)));
            int[] valoresFila = leerFila();

            for(int j = Constantes.CERO; j< Constantes.TRES; j++) {
                cuadrante[i][j] = valoresFila[j];
            }
        }
        validarArray(cuadrante);
        return cuadrante;
    }

    /**
     * Método para leer una fila de un cuadrante.
     * @return int[] arreglo con los valores de la fila.
     */
    private static int[] leerFila() {
        Scanner lector = new Scanner(System.in);
        String fila = lector.nextLine();

        if(Objects.isNull(fila) || fila.isEmpty()) {
            mostrarMensaje(Constantes.ERROR_DATOS_NO_VALIDOS);
            System.exit(Constantes.CERO);
        }

        String[] valoresFila = fila.split(Constantes.SEPARADO_COMA);
        if(valoresFila.length == 0
                || valoresFila[Constantes.CERO].isEmpty()
                || valoresFila[Constantes.UNO].isEmpty()
                || valoresFila[Constantes.DOS].isEmpty()) {
            mostrarMensaje(Constantes.ERROR_DATOS_NO_VALIDOS);
            System.exit(Constantes.CERO);
        }

        int[] valoresNumericos = new int[Constantes.TRES];
        int valorNumerico = 0;
        for (int i = Constantes.CERO; i < Constantes.TRES; i++) {
            valorNumerico = Integer.parseInt(valoresFila[i]);
            if (valorNumerico <= 0 || valorNumerico > 9) {
               mostrarMensaje(Constantes.ERROR_DATOS_NO_VALIDOS);
               System.exit(Constantes.CERO);
            }
            valoresNumericos[i] = valorNumerico;
        }

        validarNumerosDuplicados(valoresNumericos, Constantes.TRES);

        return valoresNumericos;
    }

    private static boolean validarArray(int[][] array) {
        boolean arrayValido = true;
        // Validar fila sudoku
        for (int f = Constantes.CERO; f < array.length; f++) {
            arrayValido = validarNumerosDuplicados(array[f], array.length);
        }

        // Se validan las columnas.
        int[] columna = new int[array.length];
        for (int i = Constantes.CERO; i < array.length; i++) {
            for (int j = Constantes.CERO; j < array.length; j++) {
                columna[j] = array[j][i];
            }
            arrayValido = validarNumerosDuplicados(columna, array.length); // Se validan los numeros duplicados de las columnas
        }
        return arrayValido;
    }

    /**
     * Válida que no existan números duplicados en la fila.
     * @param fila int[] Valores númericos de la fila.
     */
    private static boolean validarNumerosDuplicados(int[] fila, int limite) {
        int ultimoNumero = 0;
        for(int i = Constantes.CERO; i < limite; i++) {

            for(int j = Constantes.CERO; j < limite; j++) {
                if(j != (i-Constantes.UNO) && ultimoNumero == fila[j]) { // Si el último número es igual a cualquiera del arreglo marca error, no puede haber números duplicados.
                    mostrarMensaje(Constantes.ERROR_NUMERO_DUPLICADO);
                    return false;
                }
            }

            ultimoNumero = fila[i];
        }
        return true;
    }
}
