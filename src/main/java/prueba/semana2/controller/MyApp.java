package prueba.semana2.controller;

import javax.persistence.EntityManager;

import prueba.semana2.persistance.JPAPersistence;
import prueba.semana2.services.VehiculoManager;

public class MyApp {

    /**
     * Pide al usuario que seleccione un vehiculo y una accion.
     *
     * @param args linea de comandos
     */
    public static void main(String[] args) {
        VehiculoManager vehiculoManager = new VehiculoManager();
        
        if(vehiculoManager.createVehiculo()!= null) {
            while (!vehiculoManager.runAccion()) {
            }
        }
    }

}
