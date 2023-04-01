import utils.Utilerias;

/**
 * Clase Main del proyecto.
 *
 * @author Julián Tovar
 * @since 2023-03-31
 */
public class Ajedrez {

    /**
     * Método main de la aplicación.
     * @param args String[]
     */
    public static void main(String[] args) {
        Utilerias.imprimirInstrucciones();

        Tablero tableroAjedrez = new Tablero();
        tableroAjedrez.leerUbicacionesReinas();
        tableroAjedrez.ubicarReinasEnTablero();

        Utilerias.imprimirTablero(tableroAjedrez.getTablero());
        Utilerias.imprimirRespuesta(tableroAjedrez.validarAtaques());
    }
}
