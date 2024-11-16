package co.com.accenture.testaccenturebackend.infrastructure.exception;

/**
 * Excepcion cuando no existe una sucursal
 */
public class BranchNotFoundException extends RuntimeException {

    public BranchNotFoundException() {
        super("No existe una sucursal con el id dado.");
    }
}
