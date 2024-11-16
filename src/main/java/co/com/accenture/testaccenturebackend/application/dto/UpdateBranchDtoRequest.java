package co.com.accenture.testaccenturebackend.application.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Dto para actualizar una Sucursal
 */
@Getter
@Setter
public class UpdateBranchDtoRequest {

    /**
     * Id de la sucursal a modificar
     */
    @NotNull(message = "El id no puede ser nulo")
    private Long id;

    /**
     * Nombre nuevo de la sucursal
     */
    @NotEmpty(message = "El nombre no puede estar vacio")
    private String name;
}
