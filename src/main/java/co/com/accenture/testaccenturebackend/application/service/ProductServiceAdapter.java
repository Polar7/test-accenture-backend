package co.com.accenture.testaccenturebackend.application.service;

import co.com.accenture.testaccenturebackend.application.dto.GenericDtoResponse;
import co.com.accenture.testaccenturebackend.application.dto.SaveProductDtoRequest;
import co.com.accenture.testaccenturebackend.application.dto.UpdateNameProductDtoRequest;
import co.com.accenture.testaccenturebackend.application.dto.UpdateStockProductDtoRequest;
import co.com.accenture.testaccenturebackend.domain.model.Franchise;
import co.com.accenture.testaccenturebackend.domain.model.Product;
import co.com.accenture.testaccenturebackend.domain.repository.IBranchRepositoryPort;
import co.com.accenture.testaccenturebackend.domain.repository.IFranchiseRepositoryPort;
import co.com.accenture.testaccenturebackend.domain.repository.IProductRepositoryPort;
import co.com.accenture.testaccenturebackend.domain.usecase.IProductUseCasePort;
import co.com.accenture.testaccenturebackend.infrastructure.exception.BranchNotFoundException;
import co.com.accenture.testaccenturebackend.infrastructure.exception.FranchiseNotFoundException;
import co.com.accenture.testaccenturebackend.infrastructure.exception.ProductNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Adaptador para el servicio de Producto
 */
@Service
@RequiredArgsConstructor
public class ProductServiceAdapter implements IProductUseCasePort {

    /**
     * Repositorio de producto
     */
    private final IProductRepositoryPort productRepository;

    /**
     * Repositorio de sucursal
     */
    private final IBranchRepositoryPort branchRepository;

    /**
     * Repositorio de franquicia
     */
    private final IFranchiseRepositoryPort franchiseRepository;

    /**
     * Devuelve todos los productos
     * @return Lista con los productos existentes
     */
    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAllProducts();
    }

    /**
     * Devuelve un listado de los productos que mas stock tienen por cada sucursal de una franquicia dada
     * @param idFranchise Id de la franquicia a filtrar
     * @return Lista de productos encontrados
     */
    @Override
    public List<Product> findProductsWithMoreStock(Long idFranchise) {
        List<Optional<Product>> productsOptionalList = new ArrayList<>();
        Optional<Franchise> franchise = franchiseRepository.findFranchiseById(idFranchise);

        if (franchise.isEmpty()) {
            throw new FranchiseNotFoundException();
        }

        franchise.get().getBranches().forEach(x ->
                productsOptionalList.add(productRepository.findProductWithMoreStock(x.getId()))
        );

        return productsOptionalList.stream().flatMap(Optional::stream).toList();
    }

    /**
     * Guarda un nuevo producto en una sucursal existente
     * @param newProduct Dto del producto a crear
     * @return Dto con respuesta de la operacion
     */
    @Override
    public GenericDtoResponse saveProduct(SaveProductDtoRequest newProduct) {

        if (branchRepository.findBranchById(newProduct.getBranchId()).isEmpty()) {
            throw new BranchNotFoundException();
        }

        Product product = new Product();
        product.setName(newProduct.getName());
        product.setStock(newProduct.getStock());
        product.setBranchId(newProduct.getBranchId());

        productRepository.saveProduct(product);

        return GenericDtoResponse.builder().code(0).message("Guardado existoso del nuevo producto.").build();
    }

    /**
     * Actualiza el stock de un producto dado su id
     * @param modifyProduct Dto con la informacion a modificar
     * @return Dto con respuesta de la operacion
     */
    @Override
    public GenericDtoResponse updateStockProduct(UpdateStockProductDtoRequest modifyProduct) {

        Optional<Product> product = productRepository.findProductById(modifyProduct.getId());

        if (product.isEmpty()) {
            throw new ProductNotFound();
        }

        productRepository.saveProduct(
                product.map(x -> {
                    x.setStock(modifyProduct.getStock());
                    return x;
                }).get()
        );

        return GenericDtoResponse.builder().code(0).message("Modificacion existosa del stock del producto.").build();
    }

    /**
     * Actualiza el nombre de un producto dado su id
     * @param modifyProduct Dto con la informacion a modificar
     * @return Dto con respuesta de la operacion
     */
    @Override
    public GenericDtoResponse updateNameProduct(UpdateNameProductDtoRequest modifyProduct) {

        Optional<Product> product = productRepository.findProductById(modifyProduct.getId());

        if (product.isEmpty()) {
            throw new ProductNotFound();
        }

        productRepository.saveProduct(
                product.map(x -> {
                    x.setName(modifyProduct.getName());
                    return x;
                }).get()
        );

        return GenericDtoResponse.builder().code(0).message("Modificacion existosa del nombre del producto.").build();
    }

    /**
     * Elimina un producto dado su id
     * @param idProduct Id a buscar
     * @return Dto con respuesta de la operacion
     */
    @Override
    public GenericDtoResponse deleteProduct(Long idProduct) {

        Optional<Product> product = productRepository.findProductById(idProduct);

        if (product.isEmpty()) {
            throw new ProductNotFound();
        }

        productRepository.deleteProduct(idProduct);

        return GenericDtoResponse.builder().code(0).message("Eliminacion existosa del producto indicado.").build();
    }
}
