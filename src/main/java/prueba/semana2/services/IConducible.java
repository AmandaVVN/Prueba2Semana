package prueba.semana2.services;

/**
 * Interface Conducible.
 */
public interface IConducible { // Conducible
    boolean arrancar();

    boolean avanzar(int distancia);

    boolean retroceder(int distancia);

    boolean parar();

}
