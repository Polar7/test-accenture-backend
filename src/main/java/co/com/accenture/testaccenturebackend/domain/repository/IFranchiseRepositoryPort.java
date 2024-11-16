package co.com.accenture.testaccenturebackend.domain.repository;

import co.com.accenture.testaccenturebackend.domain.model.Franchise;

import java.util.List;
import java.util.Optional;

/**
 * Puerto para las operaciones del repositorio de una Franquicia
 */
public interface IFranchiseRepositoryPort {

    /**
     * Devuelve todas las franquicias
     * @return Lista con las franquicias existentes
     */
    List<Franchise> findAllFranchises();

    /**
     * Encuentra una franquicia dado su id
     * @param id Id a buscar
     * @return Optional con la franquicia encontrada
     */
    Optional<Franchise> findFranchiseById(Long id);

    /**
     * Encuentra una franquicia dado su nombre
     * @param name Nombre a buscar
     * @return Optional con la franquicia encontrada
     */
    Optional<Franchise> findFranchiseByName(String name);

    /**
     * Guarda una nueva franquicia
     * @param nameNewfranchise Nombre de la nueva franquicia a crear
     * @return Franquicia creada
     */
    Franchise saveFranchise(String nameNewfranchise);

    /**
     * Modifica una franquicia
     * @param franchise Franquicia a editar
     * @return Franquicia actualizada
     */
    Franchise updateFranchise(Franchise franchise);
}
