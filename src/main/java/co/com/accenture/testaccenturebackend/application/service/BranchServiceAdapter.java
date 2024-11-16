package co.com.accenture.testaccenturebackend.application.service;

import co.com.accenture.testaccenturebackend.application.dto.GenericDtoResponse;
import co.com.accenture.testaccenturebackend.application.dto.SaveBranchDtoRequest;
import co.com.accenture.testaccenturebackend.application.dto.UpdateBranchDtoRequest;
import co.com.accenture.testaccenturebackend.domain.model.Branch;
import co.com.accenture.testaccenturebackend.domain.repository.IBranchRepositoryPort;
import co.com.accenture.testaccenturebackend.domain.repository.IFranchiseRepositoryPort;
import co.com.accenture.testaccenturebackend.domain.usecase.IBranchUseCasePort;
import co.com.accenture.testaccenturebackend.infrastructure.exception.BranchNotFoundException;
import co.com.accenture.testaccenturebackend.infrastructure.exception.FranchiseNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para una Sucursal
 */
@Service
@RequiredArgsConstructor
public class BranchServiceAdapter implements IBranchUseCasePort {

    /**
     * Repositorio de sucursal
     */
    private final IBranchRepositoryPort branchRepository;

    /**
     * Repositorio de franquicia
     */
    private final IFranchiseRepositoryPort franchiseRepository;

    /**
     * Devuelve todas las sucursales
     * @return Lista con las sucursales existentes
     */
    @Override
    public List<Branch> findAllBranches() {
        return branchRepository.findAllBranches();
    }

    /**
     * Guarda una nueva sucursal
     * @param dtoNewBranch Dto de la sucursal a crear
     * @return Dto con respuesta de la operacion
     * @exception FranchiseNotFoundException Si la franquicia a la cual se quiere enlazar la sucursal no existe
     */
    @Override
    public GenericDtoResponse saveBranch(SaveBranchDtoRequest dtoNewBranch) {

        if (franchiseRepository.findFranchiseById(dtoNewBranch.getFranchiseId()).isEmpty()) {
            throw new FranchiseNotFoundException();
        }

        Branch branch = new Branch();
        branch.setName(dtoNewBranch.getName());
        branch.setFranchiseId(dtoNewBranch.getFranchiseId());
        branchRepository.saveBranch(branch);

        return GenericDtoResponse.builder().code(0).message("Guardado existoso de la nueva sucursal.").build();
    }

    /**
     * Modifica el nombre de una sucursal existente
     * @param dtoUpdateBranch Sucursal a editar
     * @return Dto con respuesta de la operacion
     * @exception BranchNotFoundException Si la sucursal a modificar no existe
     */
    @Override
    public GenericDtoResponse updateBranch(UpdateBranchDtoRequest dtoUpdateBranch) {

        Optional<Branch> modifyBranch = branchRepository.findBranchById(dtoUpdateBranch.getId());

        if (modifyBranch.isEmpty()) {
            throw new BranchNotFoundException();
        }

        branchRepository.saveBranch(
                modifyBranch.map(x -> {
                    x.setName(dtoUpdateBranch.getName());
                    return x;
                }).get()
        );

        return GenericDtoResponse.builder().code(0).message("Modificacion existosa del nombre de la sucursal.").build();
    }

}
