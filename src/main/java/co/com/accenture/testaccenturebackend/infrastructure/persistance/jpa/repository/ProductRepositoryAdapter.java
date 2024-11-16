package co.com.accenture.testaccenturebackend.infrastructure.persistance.jpa.repository;

import co.com.accenture.testaccenturebackend.domain.model.Product;
import co.com.accenture.testaccenturebackend.domain.repository.IProductRepositoryPort;
import co.com.accenture.testaccenturebackend.infrastructure.persistance.jpa.crud.IProductCrudRepository;
import co.com.accenture.testaccenturebackend.infrastructure.persistance.jpa.mapper.IProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Adaptador para las operaciones del repositorio de un Producto
 */
@Repository
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements IProductRepositoryPort {

    /**
     * Interfaz crud de producto
     */
    private final IProductCrudRepository productCrudRepository;

    /**
     * Mapper de producto
     */
    private final IProductMapper productMapper;

    /**
     * Devuelve todos los productos
     * @return Lista con los productos existentes
     */
    @Override
    public List<Product> findAllProducts() {
        return productMapper.toDtoList(productCrudRepository.findAll());
    }

    /**
     * Encuentra un producto dado su id
     * @param id Id del producto a buscar
     * @return Optional con el producto encontrado
     */
    @Override
    public Optional<Product> findProductById(Long id) {
        return productCrudRepository.findById(id).map(productMapper::toDto);
    }

    /**
     * Encuentra el producto que mas stock tiene en una sucursal dada
     * @param branchId Id de la sucursal a buscar
     * @return Optional con el Producto encontrado
     */
    @Override
    public Optional<Product> findProductWithMoreStock(Long branchId) {
        return productCrudRepository.findTopByBranchIdOrderByStockDesc(branchId).map(productMapper::toDto);
    }

    /**
     * Guarda o modifica un producto
     * @param product Producto a crear/modificar
     * @return Producto creado/modificado
     */
    @Override
    public Product saveProduct(Product product) {
        return productMapper.toDto(
                productCrudRepository.save(productMapper.toEntity(product))
        );
    }

    /**
     * Elimina un producto dado su id
     * @param idProduct Id del producto a buscar
     */
    @Override
    public void deleteProduct(Long idProduct) {
        productCrudRepository.deleteById(idProduct);
    }

}
