package co.com.accenture.testaccenturebackend.application.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Dto para actualizar el nombre de un producto
 */
@Getter
@Setter
public class UpdateProductNameDtoRequest {

    /**
     * Id del producto
     */
    private Long id;

    /**
     * Nombre a modificar
     */
    private String name;
}
