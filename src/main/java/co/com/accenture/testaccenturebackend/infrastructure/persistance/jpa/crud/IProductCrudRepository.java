package co.com.accenture.testaccenturebackend.infrastructure.persistance.jpa.crud;

import co.com.accenture.testaccenturebackend.infrastructure.persistance.jpa.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Crud de la entidad Producto
 */
public interface IProductCrudRepository extends JpaRepository<ProductEntity, Long> {

    /**
     * Encuentra el producto que mas stock tiene en una sucursal dada
     * @param branchId Id de la sucursal a buscar
     * @return Optional con el Producto encontrado
     */
    Optional<ProductEntity> findTopByBranchIdOrderByStockDesc(Long branchId);
}
