package co.com.accenture.testaccenturebackend.infrastructure.entrypoint.rest;

import co.com.accenture.testaccenturebackend.application.dto.GenericDtoResponse;
import co.com.accenture.testaccenturebackend.application.dto.SaveFranchiseDtoRequest;
import co.com.accenture.testaccenturebackend.application.dto.UpdateFranchiseNameDtoRequest;
import co.com.accenture.testaccenturebackend.domain.model.Franchise;
import co.com.accenture.testaccenturebackend.domain.usecase.IFranchiseUseCasePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "FranchiseController", description = "Controlador para lo relacionado con 'Franquicia'")
@RestController
@RequestMapping("franchise")
@RequiredArgsConstructor
public class FranchiseController {

    /**
     * Casos de uso de franquicia
     */
    private final IFranchiseUseCasePort franchiseUseCase;

    /**
     * Devuelve todas las franquicias
     * @return ResponseEntity con el listado de franquicias
     */
    @Operation(summary = "Devuelve todas las franquicias")
    @GetMapping
    public ResponseEntity<List<Franchise>> getAllFranchise() {
        return ResponseEntity.ok(franchiseUseCase.findAllFranchises());
    }

    /**
     * Crea una nueva franquicia
     * @param dtoNewFranchise JSON de la franquicia a crear
     * @return ResponseEntity con la confirmacion del guardado de la franquicia
     */
    @Operation(summary = "Crea una nueva franquicia")
    @PostMapping
    public ResponseEntity<GenericDtoResponse> saveFranchise(@Valid @RequestBody SaveFranchiseDtoRequest dtoNewFranchise) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(franchiseUseCase.saveFranchise(dtoNewFranchise));
    }

    /**
     * Modifica el nombre de una franquicia
     * @param dtoUpdateFranchise JSON de la franquicia a actualizar
     * @return ResponseEntity con la confirmacion de la actualizacion de la franquicia
     */
    @Operation(summary = "Modifica el nombre de una franquicia")
    @PatchMapping
    public ResponseEntity<GenericDtoResponse> updateFranchise(@Valid @RequestBody UpdateFranchiseNameDtoRequest dtoUpdateFranchise) {
        return ResponseEntity.ok(franchiseUseCase.updateFranchise(dtoUpdateFranchise));
    }
}
