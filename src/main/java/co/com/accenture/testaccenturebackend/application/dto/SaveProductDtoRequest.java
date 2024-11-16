package co.com.accenture.testaccenturebackend.application.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Dto para crear un nuevo Producto
 */
@Getter
@Setter
public class SaveProductDtoRequest {

    /**
     * Nombre del producto
     */
    @NotEmpty(message = "El nombre no puede estar vacio")
    private String name;

    /**
     * Unidades disponibles del producto
     */
    @NotNull(message = "El stock no puede ser nulo")
    private Long stock;

    /**
     * Id de la sucursal donde se encuentra el producto
     */
    @NotNull(message = "El id de la sucursal no puede ser nulo")
    private Long branchId;
}
