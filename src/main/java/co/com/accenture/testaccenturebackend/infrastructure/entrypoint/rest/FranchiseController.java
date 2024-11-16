package co.com.accenture.testaccenturebackend.infrastructure.entrypoint.rest;

import co.com.accenture.testaccenturebackend.application.dto.GenericDtoResponse;
import co.com.accenture.testaccenturebackend.application.dto.SaveFranchiseDtoRequest;
import co.com.accenture.testaccenturebackend.application.dto.UpdateFranchiseDtoRequest;
import co.com.accenture.testaccenturebackend.domain.model.Franchise;
import co.com.accenture.testaccenturebackend.domain.usecase.IFranchiseUseCasePort;
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
    @GetMapping
    public ResponseEntity<List<Franchise>> getAllFranchise() {
        return ResponseEntity.ok(franchiseUseCase.findAllFranchises());
    }

    /**
     * Crea una nueva franquicia
     * @param dtoNewFranchise JSON de la franquicia a crear
     * @return ResponseEntity con la confirmacion del guardado de la franquicia
     */
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
    @PatchMapping
    public ResponseEntity<GenericDtoResponse> updateFranchise(@Valid @RequestBody UpdateFranchiseDtoRequest dtoUpdateFranchise) {
        return ResponseEntity.ok(franchiseUseCase.updateFranchise(dtoUpdateFranchise));
    }
}
