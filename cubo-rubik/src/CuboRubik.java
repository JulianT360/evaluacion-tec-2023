import utilerias.Constantes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utilerias.Utilerias.mostrarMensaje;

/**
 * Clase de cubo de rubik que puede leer los colores de cada cara y validar las caras.
 *
 * @author Julián Tovar
 * @since 2023-03-31
 */
public class CuboRubik {

    private int cantidadCaras;
    private String[] coloresRubik;
    private List<String[]> caras;

    public CuboRubik() {
        this.cantidadCaras = 6;
        this.coloresRubik = new String[]{"0", "1", "2", "3", "4", "5"};
        this.caras = new ArrayList<>();
    }

    public CuboRubik(int cantidadCaras, String[] coloresRubik) {
        this.cantidadCaras = cantidadCaras;
        this.coloresRubik = coloresRubik;
        this.caras = new ArrayList<>();
    }

    /**
     * Método para leer los colores de una cara.
     * @return Arreglo con los colores de una cara.
     */
    private String[] leerCara() {
        Scanner lector = new Scanner(System.in);
        String cara = lector.nextLine();

        if(cara.isEmpty()) {
            mostrarMensaje("Datos inválidos, ingrese un dato válido para continuar.");
            System.exit(0);
        }

        String[] coloresCara = cara.split(",");
        if(coloresCara.length != 9) {
            mostrarMensaje("Datos inválidos, ingrese la cantidad de colores correcta.");
            System.exit(0);
        }
        return coloresCara;
    }

    /**
     * Método para leer las caras del cubo de rubik.
     *
     */
    public void leerCaras () {
        // Se leen las caras del cubo de rubik.
        for(int i = 1; i <= this.cantidadCaras; i++) {
            mostrarMensaje(String.format(Constantes.MENSAJE_INGRESAR_DATOS, i));
            caras.add(leerCara());
        }
    }

    /**
     * Método para validar el cubo de rubik.
     * @return True si es un cubo armado correctamente, false si no esta armado correctamente.
     */
    public boolean validarCuboRubik() {
        boolean cuboValido = true;
        // Sé válida las caras y los colores de cubo de rubik.
        for(String[] cara : caras) {
            if(!validarColoresCara(cara)) {
                cuboValido = false;
            }
        }
        return cuboValido;
    }

    /**
     * Método para validar los colores de una cara.
     *
     * @param cara Arreglo con los colores de la cara del cubo.
     * @return True si es una cara válida, False si no cumple con los criterios
     */
    private boolean validarColoresCara(String[] cara) {

        // Válida si el color de la cara a revisar ya ha sido revisado anteriormente.
        if (validarColorRevisado(cara[0])) {
            mostrarMensaje("Error: Color duplicado");
            return false;
        }

        String ultimoColor = cara[0];
        for(int i = 1; i < cara.length; i++) {

            // Valida que los colores de la cara sean iguales.
            if(!ultimoColor.equals(cara[i])) {
                return false;
            }

            ultimoColor = cara[i]; // Actualiza el último color con el color actual.
        }
        return true;
    }

    /**
     * Método para validar si el color a revisar ya ha sido revisado en otra cara.
     *
     * @param color Color a revisar.
     * @return Si el color ya ha sido revisado (true) o no (false).
     */
    private boolean validarColorRevisado(String color) {
        for(int i = 0; i < coloresRubik.length; i++) {
            if(coloresRubik[i].equals(color)) { // Si se encuentra el color a validar, el color se borra del arreglo de colores.
                coloresRubik[i] = "";
                return false;
            }
        }
        return true;
    }
}
