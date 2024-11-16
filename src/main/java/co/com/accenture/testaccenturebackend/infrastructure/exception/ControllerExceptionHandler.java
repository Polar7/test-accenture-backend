package co.com.accenture.testaccenturebackend.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {

    /**
     * Captura las excepciones basadas en logica de negocio
     * @param e Excepcion lanzada
     * @return ProblemDetail con codigo de estado CONFLICT y su mensaje
     */
    @ExceptionHandler({FranchiseNameAlreadyExistsExcepcion.class, FranchiseNotFoundException.class})
    public ProblemDetail functionalException(RuntimeException e) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, e.getMessage());
    }

    /**
     * Captura las excepciones lanzadas por Validation
     * cuando el JSON recibido en el controlador no cumple con las condiciones correctas
     * @param e Excepcion lanzada
     * @return ProblemDetail con la lista de los campos donde existe error
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail methodArgumentNotValidException(MethodArgumentNotValidException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Error con los campos en el JSON enviado.");

        Map<String, Object> error = new HashMap<>();
        Map<String, String> errorsValidation = new HashMap<>();

        e.getFieldErrors().forEach(x -> errorsValidation.put(x.getField(), x.getDefaultMessage()));

        error.put("validations", errorsValidation);
        problemDetail.setProperties(error);

        return problemDetail;
    }
}
