package co.com.accenture.testaccenturebackend.infrastructure.persistance.jpa.crud;

import co.com.accenture.testaccenturebackend.infrastructure.persistance.jpa.entity.FranchiseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Crud de la entidad Franquicia
 */
public interface IFranchiseCrudRepository extends JpaRepository<FranchiseEntity, Long> {

    /**
     * Encuentra una franquicia dado su nombre
     * @param franchiseName Nombre a buscar
     * @return Entidad encontrada
     */
    Optional<FranchiseEntity> findByName(String franchiseName);
}
