package co.com.accenture.testaccenturebackend.domain.repository;

import co.com.accenture.testaccenturebackend.domain.model.Product;

import java.util.List;
import java.util.Optional;

/**
 * Puerto para las operaciones del repositorio de un Producto
 */
public interface IProductRepositoryPort {

    /**
     * Devuelve todos los productos
     * @return Lista con los productos existentes
     */
    List<Product> findAllProducts();

    /**
     * Encuentra un producto dado su id
     * @param id Id del producto a buscar
     * @return Optional con el producto encontrado
     */
    Optional<Product> findProductById(Long id);

    /**
     * Encuentra el producto que mas stock tiene en una sucursal dada
     * @param branchId Id de la sucursal a buscar
     * @return Optional con el Producto encontrado
     */
    Optional<Product> findProductWithMoreStock(Long branchId);

    /**
     * Guarda o modifica un producto
     * @param product Producto a crear/modificar
     * @return Producto creado/modificado
     */
    Product saveProduct(Product product);

    /**
     * Elimina un producto dado su id
     * @param idProduct Id del producto a buscar
     */
    void deleteProduct(Long idProduct);
}
