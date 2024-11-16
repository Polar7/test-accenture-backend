package co.com.accenture.testaccenturebackend.domain.repository;

import co.com.accenture.testaccenturebackend.domain.model.Branch;

import java.util.List;
import java.util.Optional;

/**
 * Puerto para las operaciones del repositorio de una Sucursal
 */
public interface IBranchRepositoryPort {

    /**
     * Devuelve todas las sucursales
     * @return Lista con las sucursales existentes
     */
    List<Branch> findAllBranches();

    /**
     * Encuentra una sucursal dado su id
     * @param id Id a buscar
     * @return Optional con la sucursal encontrada
     */
    Optional<Branch> findBranchById(Long id);

    /**
     * Guarda o modifica una sucursal
     * @param branch Sucursal a crear/modificar
     * @return Sucursal creada/modificada
     */
    Branch saveBranch(Branch branch);

}
