package co.com.accenture.testaccenturebackend.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Dto generico para respuestas
 */
@Getter
@Setter
@Builder
public class GenericDtoResponse {

    /**
     * Codigo de estado
     */
    private int code;

    /**
     * Mensaje de respuesta
     */
    private String message;
}
