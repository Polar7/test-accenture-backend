package co.com.accenture.testaccenturebackend.domain.usecase;

import co.com.accenture.testaccenturebackend.application.dto.GenericDtoResponse;
import co.com.accenture.testaccenturebackend.application.dto.SaveProductDtoRequest;
import co.com.accenture.testaccenturebackend.application.dto.UpdateProductNameDtoRequest;
import co.com.accenture.testaccenturebackend.application.dto.UpdateProductStockDtoRequest;
import co.com.accenture.testaccenturebackend.domain.model.Product;

import java.util.List;

/**
 * Puerto para los casos de uso de un Producto
 */
public interface IProductUseCasePort {

    /**
     * Devuelve todos los productos
     * @return Lista con los productos existentes
     */
    List<Product> findAllProducts();

    /**
     * Devuelve un listado de los productos que mas stock tienen por cada sucursal de una franquicia dada
     * @param idFranchise Id de la franquicia a filtrar
     * @return Lista de productos encontrados
     */
    List<Product> findProductsWithMoreStock(Long idFranchise);

    /**
     * Guarda un nuevo producto en una sucursal existente
     * @param newProduct Dto del producto a crear
     * @return Dto con respuesta de la operacion
     */
    GenericDtoResponse saveProduct(SaveProductDtoRequest newProduct);

    /**
     * Actualiza el stock de un producto dado su id
     * @param modifyProduct Dto con la informacion a modificar
     * @return Dto con respuesta de la operacion
     */
    GenericDtoResponse updateStockProduct(UpdateProductStockDtoRequest modifyProduct);

    /**
     * Actualiza el nombre de un producto dado su id
     * @param modifyProduct Dto con la informacion a modificar
     * @return Dto con respuesta de la operacion
     */
    GenericDtoResponse updateNameProduct(UpdateProductNameDtoRequest modifyProduct);

    /**
     * Elimina un producto dado su id
     * @param idProduct Id a buscar
     * @return Dto con respuesta de la operacion
     */
    GenericDtoResponse deleteProduct(Long idProduct);
}
