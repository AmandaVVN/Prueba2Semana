package prueba.semana2;

public class MyApp {

    /**
     * Pide al usuario que seleccione un vehiculo y una accion.
     *
     * @param args linea de comandos
     */
    public static void main(String[] args) {
        // Creamos 3 vehiculos, uno de cada tipo, ademas de declara las variables
        // necesarias
        VehiculoManager vehiculoManager = new VehiculoManager();
        vehiculoManager.createVehiculo();
        while (!vehiculoManager.runAccion()) {
        }

    }

}
