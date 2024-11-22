package co.com.accenture.testaccenturebackend.infrastructure.entrypoint.rest;

import co.com.accenture.testaccenturebackend.application.dto.GenericDtoResponse;
import co.com.accenture.testaccenturebackend.application.dto.SaveProductDtoRequest;
import co.com.accenture.testaccenturebackend.application.dto.UpdateProductNameDtoRequest;
import co.com.accenture.testaccenturebackend.application.dto.UpdateProductStockDtoRequest;
import co.com.accenture.testaccenturebackend.domain.model.Product;
import co.com.accenture.testaccenturebackend.domain.usecase.IProductUseCasePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "ProductController", description = "Controlador para lo relacionado con 'Producto'")
@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    /**
     * Casos de uso de Producto
     */
    private final IProductUseCasePort productUseCase;

    /**
     * Devuelve todos los productos
     * @return ResponseEntity con la Lista de los productos existentes
     */
    @Operation(summary = "Devuelve todos los productos")
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productUseCase.findAllProducts());
    }

    /**
     * Devuelve un listado de los productos que mas stock tienen por cada sucursal de una franquicia dada
     * @param idFranchise Id de la franquicia a filtrar
     * @return ResponseEntity con Lista de productos encontrados
     */
    @Operation(summary = "Devuelve un listado de los productos que mas stock tienen por cada sucursal de una franquicia dada")
    @GetMapping(path = "more-stock/{idFranchise}")
    public ResponseEntity<List<Product>> getProductsWithMoreStock(@PathVariable Long idFranchise) {
        return ResponseEntity.ok(productUseCase.findProductsWithMoreStock(idFranchise));
    }

    /**
     * Guarda un nuevo producto en una sucursal existente
     * @param newProduct Dto del producto a crear
     * @return ResponseEntity con Dto con respuesta de la operacion
     */
    @Operation(summary = "Guarda un nuevo producto en una sucursal existente")
    @PostMapping
    public ResponseEntity<GenericDtoResponse> createProduct(@RequestBody SaveProductDtoRequest newProduct) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productUseCase.saveProduct(newProduct));
    }

    /**
     * Actualiza el stock de un producto dado su id
     * @param modifyProduct Dto con la informacion a modificar
     * @return ResponseEntity con Dto con respuesta de la operacion
     */
    @Operation(summary = "Actualiza el stock de un producto dado su id")
    @PatchMapping(path = "stock")
    public ResponseEntity<GenericDtoResponse> updateStockProduct(UpdateProductStockDtoRequest modifyProduct) {
        return ResponseEntity.ok(productUseCase.updateStockProduct(modifyProduct));
    }

    /**
     * Actualiza el nombre de un producto dado su id
     * @param modifyProduct Dto con la informacion a modificar
     * @return ResponseEntity con Dto con respuesta de la operacion
     */
    @Operation(summary = "Actualiza el nombre de un producto dado su id")
    @PatchMapping(path = "name")
    public ResponseEntity<GenericDtoResponse> updateNameProduct(UpdateProductNameDtoRequest modifyProduct) {
        return ResponseEntity.ok(productUseCase.updateNameProduct(modifyProduct));
    }

    /**
     * Elimina un producto dado su id
     * @param idProduct Id a buscar
     * @return ResponseEntity con Dto con respuesta de la operacion
     */
    @Operation(summary = "Elimina un producto dado su id")
    @DeleteMapping(path = "{idProduct}")
    public ResponseEntity<GenericDtoResponse> deleteProduct(@PathVariable Long idProduct) {
        return ResponseEntity.ok(productUseCase.deleteProduct(idProduct));
    }
}
