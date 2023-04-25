package prueba.semana2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Moto.java Clase para el objecto Moto
 */

@Entity
@Table(name = "moto")
public class Moto extends Vehiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_moto;
	@Column
    private String tipoMoto;
	@Column
    protected static final String TIPO = "Moto";

    /**
     * Constructor de la clase Moto.
     *
     * @param color     El color del Moto.
     * @param marca     La marca del Moto.
     * @param precio    El precio del Moto.
     * @param matricula La matricula del Moto.
     * @param tipoMoto El tipo de Moto.
     */
    public Moto(String color, String marca, String precio, String matricula, String tipoMoto) {
        super(color, marca, precio, matricula, 2); // Una moto siempre tiene 2 ruedas
        this.tipoMoto = tipoMoto;

    }

    public String getTipoMoto() {
        return tipoMoto;
    }

    @Override
    public void imprimirDatos() {
        System.out.println("Este vehiculo es una moto");
        System.out.println("Esta moto es de tipo " + tipoMoto);
        super.imprimirDatos();
    }
}
