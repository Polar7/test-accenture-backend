package co.com.accenture.testaccenturebackend.application.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

/**
 * Dto para crear una nueva Franquicia
 */
@Getter
@Setter
public class SaveFranchiseDtoRequest {

    /**
     * Nombre de la nueva franquicia
     */
    @NotEmpty(message = "El nombre no puede estar vacio")
    private String name;
}
