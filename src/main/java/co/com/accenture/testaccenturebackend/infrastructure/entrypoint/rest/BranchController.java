package co.com.accenture.testaccenturebackend.infrastructure.entrypoint.rest;

import co.com.accenture.testaccenturebackend.application.dto.GenericDtoResponse;
import co.com.accenture.testaccenturebackend.application.dto.SaveBranchDtoRequest;
import co.com.accenture.testaccenturebackend.application.dto.UpdateBranchDtoRequest;
import co.com.accenture.testaccenturebackend.domain.model.Branch;
import co.com.accenture.testaccenturebackend.domain.usecase.IBranchUseCasePort;
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
@RequestMapping("branch")
@RequiredArgsConstructor
public class BranchController {

    /**
     * Casos de uso de franquicia
     */
    private final IBranchUseCasePort branchUseCase;

    /**
     * Devuelve todas las sucursales
     * @return ResponseEntity con el listado de sucursales
     */
    @GetMapping
    public ResponseEntity<List<Branch>> getAllBranches() {
        return ResponseEntity.ok(branchUseCase.findAllBranches());
    }

    /**
     * Crea una nueva sucursal
     * @param dtoNewBranch JSON de la sucursal a crear
     * @return ResponseEntity con la confirmacion del guardado de la sucursal
     */
    @PostMapping
    public ResponseEntity<GenericDtoResponse> saveBranch(@Valid @RequestBody SaveBranchDtoRequest dtoNewBranch) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(branchUseCase.saveBranch(dtoNewBranch));
    }

    /**
     * Modifica el nombre de una sucursal
     * @param dtoUpdateBranch JSON de la sucursal a actualizar
     * @return ResponseEntity con la confirmacion de la actualizacion de la sucursal
     */
    @PatchMapping
    public ResponseEntity<GenericDtoResponse> updateFranchise(@Valid @RequestBody UpdateBranchDtoRequest dtoUpdateBranch) {
        return ResponseEntity.ok(branchUseCase.updateBranch(dtoUpdateBranch));
    }

}
