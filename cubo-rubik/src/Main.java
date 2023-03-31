import static utilerias.Utilerias.mostrarInstrucciones;
import static utilerias.Utilerias.mostrarRespuestas;

/**
 * Validador de armado de un cubo de rubik.
 *
 * @author Julián Tovar
 * @since 2023-03-31
 */
public class Main {

    /**
     * Método main de la aplicación Java.
     * @param args String[].
     */
    public static void main(String[] args) {
        // Muestra instrucciones de inicio.
        mostrarInstrucciones();

        // Se genera un objeto cubo de rubik para acceder a sus métodos.
        CuboRubik cuboRubik = new CuboRubik();
        cuboRubik.leerCaras();

        // Se muestra la respuesta.
        mostrarRespuestas(cuboRubik.validarCuboRubik());
    }
}
