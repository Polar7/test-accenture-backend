package co.com.accenture.testaccenturebackend.infrastructure.persistance.jpa.crud;

import co.com.accenture.testaccenturebackend.infrastructure.persistance.jpa.entity.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Crud de la entidad Sucursal
 */
public interface IBranchCrudRepository extends JpaRepository<BranchEntity, Long> {
}
