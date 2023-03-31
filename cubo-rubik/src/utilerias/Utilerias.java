package utilerias;

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

    /**
     * Método para mostrar las instrucciones del programa.
     */
    public static void mostrarInstrucciones() {
        mostrarMensaje(Constantes.SEPARADOR);
        mostrarMensaje("---------- Validador para Cubo Rubik ----------");
        mostrarMensaje(Constantes.SEPARADOR);
        mostrarMensaje("Indicador de colores");
        mostrarMensaje("0.- Blanco");
        mostrarMensaje("1.- Azul");
        mostrarMensaje("2.- Rojo");
        mostrarMensaje("3.- Verde");
        mostrarMensaje("4.- Amarillo");
        mostrarMensaje("5.- Naranja");

        mostrarMensaje(Constantes.SEPARADOR);
        mostrarMensaje("Instrucciones: Ingrese el valor de cada una de las caras del cubo de rubik, utilizando el siguiente formato: 0,1,2,0,4,5,5,0,2");
        mostrarMensaje(Constantes.SEPARADOR);
    }

    /**
     * Método para mostrar el texto de la respuesta si se trata de un cubo armado correctamente o no.
     * @param isValido Cubo válido (true) o inválido (false).
     */
    public static void mostrarRespuestas(boolean isValido) {
        mostrarMensaje(Constantes.SEPARADOR);
        mostrarMensaje(String.format("El cubo de rubik %s esta armado correctamente.", (isValido ? "" : "NO")));
    }
}
