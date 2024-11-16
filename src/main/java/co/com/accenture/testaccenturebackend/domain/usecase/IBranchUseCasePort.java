package co.com.accenture.testaccenturebackend.domain.usecase;

import co.com.accenture.testaccenturebackend.application.dto.GenericDtoResponse;
import co.com.accenture.testaccenturebackend.application.dto.SaveBranchDtoRequest;
import co.com.accenture.testaccenturebackend.application.dto.UpdateBranchDtoRequest;
import co.com.accenture.testaccenturebackend.domain.model.Branch;

import java.util.List;

/**
 * Puerto para los casos de uso de una Sucursal
 */
public interface IBranchUseCasePort {

    /**
     * Devuelve todas las sucursales
     * @return Lista con las sucursales existentes
     */
    List<Branch> findAllBranches();

    /**
     * Guarda una nueva sucursal
     * @param dtoNewBranch Dto de la sucursal a crear
     * @return Dto con respuesta de la operacion
     */
    GenericDtoResponse saveBranch(SaveBranchDtoRequest dtoNewBranch);

    /**
     * Modifica el nombre de una sucursal existente
     * @param dtoUpdateBranch Sucursal a editar
     * @return Dto con respuesta de la operacion
     */
    GenericDtoResponse updateBranch(UpdateBranchDtoRequest dtoUpdateBranch);

}
