package co.com.accenture.testaccenturebackend.infrastructure.exception;

/**
 * Excepcion cuando no existe una franquicia
 */
public class FranchiseNotFoundException extends RuntimeException {

    public FranchiseNotFoundException() {
        super("No existe una franquicia con el id dado.");
    }
}
