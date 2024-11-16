package co.com.accenture.testaccenturebackend.infrastructure.persistance.jpa.repository;

import co.com.accenture.testaccenturebackend.domain.model.Branch;
import co.com.accenture.testaccenturebackend.domain.repository.IBranchRepositoryPort;
import co.com.accenture.testaccenturebackend.infrastructure.persistance.jpa.crud.IBranchCrudRepository;
import co.com.accenture.testaccenturebackend.infrastructure.persistance.jpa.mapper.IBranchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BranchRepositoryAdapter implements IBranchRepositoryPort {

    /**
     * Interfaz crud de sucursal
     */
    private final IBranchCrudRepository branchCrudRepository;

    /**
     * Mapper de sucursal
     */
    private final IBranchMapper branchMapper;

    /**
     * Devuelve todas las sucursales
     * @return Lista con las sucursales existentes
     */
    @Override
    public List<Branch> findAllBranches() {
        return branchMapper.toDtoList(branchCrudRepository.findAll());
    }

    /**
     * Encuentra una sucursal dado su id
     * @param id Id a buscar
     * @return Optional con la sucursal encontrada
     */
    @Override
    public Optional<Branch> findBranchById(Long id) {
        return branchCrudRepository.findById(id).map(branchMapper::toDto);
    }

    /**
     * Guarda o modifica una sucursal
     * @param branch Sucursal a crear/modificar
     * @return Sucursal creada/modificada
     */
    @Override
    public Branch saveBranch(Branch branch) {
        return branchMapper.toDto(
                branchCrudRepository.save(branchMapper.toEntity(branch))
        );
    }

}
