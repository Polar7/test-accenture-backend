package co.com.accenture.testaccenturebackend.application.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateFranchiseDtoRequest {

    /**
     * Id de la franquicia a modificar
     */
    @NotNull(message = "El id no puede ser nulo")
    private Long id;

    /**
     * Nombre nuevo de la franquicia
     */
    @NotEmpty(message = "El nombre no puede estar vacio")
    private String name;
}
