package co.com.accenture.testaccenturebackend.infrastructure.exception;

/**
 * Excepcion cuando no existe un producto
 */
public class ProductNotFound extends RuntimeException {

    public ProductNotFound() {
        super("No existe un producto con el id dado.");
    }
}
