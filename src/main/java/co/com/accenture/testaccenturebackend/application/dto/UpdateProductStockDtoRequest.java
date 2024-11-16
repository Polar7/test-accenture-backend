package co.com.accenture.testaccenturebackend.application.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Dto para actualizar el stock de un producto
 */
@Getter
@Setter
public class UpdateProductStockDtoRequest {

    /**
     * Id del producto
     */
    private Long id;

    /**
     * Unidades disponibles a actualizar
     */
    private Long stock;
}
