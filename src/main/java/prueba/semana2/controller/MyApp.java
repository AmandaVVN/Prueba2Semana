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
        // Creamos 3 vehiculos, uno de cada tipo, ademas de declara las variables
        // necesarias
        VehiculoManager vehiculoManager = new VehiculoManager();
        //EntityManager entity = JPAPersistence.getEntityManagerFactory().createEntityManager();
        
        if(vehiculoManager.createVehiculo()!= null) {
            while (!vehiculoManager.runAccion()) {
            }
        }
    }

}
