package prueba.semana2;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.apache.logging.log4j.core.Logger;
import org.junit.Before;

import prueba.semana2.model.Coche;
import prueba.semana2.persistance.JPAPersistence;
import prueba.semana2.services.VehiculoManager;



public class MyAppTest {

	private EntityManager entity = JPAPersistence.getEntityManagerFactory().createEntityManager();
	private VehiculoManager VehManager = new VehiculoManager();
	
	@Test
	public void CreacionVehiculo() {
        Coche coche = new Coche("Rojo", "Toyota", "20.000 €", "SADF12", "Manual");       
        VehManager.registrarVehiculo(coche);
	}
	
	@Test
	public void ConsultaVehiculo() {
		VehManager.ConsultaDatos();

	}
	
}
