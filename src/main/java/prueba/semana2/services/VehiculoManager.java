package prueba.semana2.services;

import javax.persistence.EntityManager;

import com.mysql.cj.MysqlType;

import prueba.semana2.model.Barco;
import prueba.semana2.model.Coche;
import prueba.semana2.model.Moto;
import prueba.semana2.model.Vehiculo;
import prueba.semana2.persistance.JPAPersistence;


/**
 * VehiculoManager
 * Se encarga de gestionar los Vehiculos.
 */
public class VehiculoManager {
    private Vehiculo vehiculo;
	private EntityManager entity = JPAPersistence.getEntityManagerFactory().createEntityManager();

    private InputHandler inputHandler = new InputHandler();
    
    /**
     * Método para crear un Vehiculo siguiendo el input del usuario.
     *
     * @return Vehiculo vehiculo
     */
    public Vehiculo createVehiculo() {

        Integer tipoVehiculo = inputHandler.getTipoVehiculo();

        switch (tipoVehiculo) {
            case 0: // Coche
                this.vehiculo = this.createCoche();
                break;
            case 1: // Moto
                this.vehiculo = this.createMoto();
                break;
            case 2: // Barco
                this.vehiculo = this.createBarco();
                break;
            case 3: //Consultar
            	ConsultaDatos();
                break;
            case 4: // Salir
                break;

            default: // Como default por opcion no incluida, salir
                System.out.println("No se ha encontrado una opción válida.");
                return null;
        }
        
        if(vehiculo != null) {
        	registrarVehiculo(vehiculo);
        }
        
        return vehiculo; // no se ha encontrado ningun resultado valido

    }

    private Vehiculo createCoche() {
        Coche coche = new Coche("Rojo", "Toyota", "20.000 €", "SADF12", "Manual");
        
        System.out.println(
                "Se ha creado un vehículo de tipo Coche ");
        return coche;
    }

    private Vehiculo createMoto() {
        Moto moto = new Moto("Negro", "Yamaha", "50.000 €", "YTUI78", "Motocross");
        System.out.println(
                "Se ha creado un vehículo de tipo Moto ");
        return moto;
    }

    private Vehiculo createBarco() {
        Barco barco = new Barco("Rojo", "Toyota", "20.000 €", "VBNM76", "Yate");
        System.out.println(
                "Se ha creado un vehículo de tipo Barco ");
        return barco;
    }
    /*
     * Añade registros a la base de datos
     */
    
    public void registrarVehiculo(Vehiculo vehiculo) {
    	
		entity.getTransaction().begin();
		entity.persist(vehiculo);
		entity.getTransaction().commit();
		
		System.out.println("Vehiculo registrado.");
		System.out.println();
    }
    
    /*
     * Metodo que busca el vehiculo en la base de datos
     */
    private Vehiculo devolverVehiculo(Vehiculos veh, int idVeh) throws ClassNotFoundException {
    	   	
    	Class clase = Class.forName(Vehiculo.class.getPackage().getName() + "." + veh.toString());
    	Vehiculo vehEncontrado = (Vehiculo) entity.find(clase, idVeh );
   	
    	return vehEncontrado;
    }
    
    /**
     * pregunta y ejecuta
     * la accion del usuario.
     */
    public boolean runAccion() {

        Integer accion = inputHandler.getAccion();
        
        switch (accion) {
            case 0: // Opcion arranque
                return vehiculo.arrancar();
            case 1: // Opcion parar
                return vehiculo.parar();
            case 2: // Opcion avanzar
                intentarMoverse(accion);
            case 3: // Opcion retroceder
                intentarMoverse(accion);
            case 4: // Opcion imprimir datos
                vehiculo.imprimirDatos();
                return false;
            case 5: // Salir
                return true;
            default: // Como default por opcion no incluida, salir
                return true;

        }
    }
    
    /*
     * Metodo que consulta la base de datos
     */
    public boolean ConsultaDatos() {
    	
    	Integer accion = inputHandler.getVehiculoBD();
        
    	if(accion>= 3) return false;
    	try {
			devolverVehiculo(Vehiculos.values()[accion],1).imprimirDatos();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	return true;
    }
    
    
    /* 
     * Metodo para centralizar el movimiento del coche
     * 
     */
    public boolean intentarMoverse(Integer opc) {
    	if (vehiculo.isArrancado()) {

    		boolean resultado = (opc == 2)? vehiculo.avanzar(inputHandler.getMetros()) :  vehiculo.retroceder(inputHandler.getMetros());

    		 return resultado;

        } else {
            System.out.println(
                    "El vehiculo no esta en marcha "
                            + "por favor arranque antes de intentar moverte.");
            return false;
        }

    }

    private enum Vehiculos{
    	Coche,
    	Moto,
    	Barco
    }
}
