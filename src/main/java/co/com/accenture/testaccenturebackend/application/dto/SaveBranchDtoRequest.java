package co.com.accenture.testaccenturebackend.application.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Dto para crear una nueva Sucursal
 */
@Getter
@Setter
public class SaveBranchDtoRequest {

    /**
     * Id de la franquicia a la que pertenece la sucursal
     */
    @NotNull(message = "El id de la franquicia no puede estar vacio")
    private Long franchiseId;

    /**
     * Nombre de la nueva sucursal
     */
    @NotEmpty(message = "El nombre no puede estar vacio")
    private String name;
}
