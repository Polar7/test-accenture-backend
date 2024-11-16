package co.com.accenture.testaccenturebackend.infrastructure.exception;

/**
 * Excepcion cuando el nombre de una franquicia ya existe
 */
public class FranchiseNameAlreadyExistsExcepcion extends RuntimeException {

    public FranchiseNameAlreadyExistsExcepcion() {
        super("Ya existe una Franquicia con el nombre ingresado");
    }

}
