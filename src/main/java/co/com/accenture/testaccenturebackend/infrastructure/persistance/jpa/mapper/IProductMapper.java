package co.com.accenture.testaccenturebackend.infrastructure.persistance.jpa.mapper;

import co.com.accenture.testaccenturebackend.domain.model.Product;
import co.com.accenture.testaccenturebackend.infrastructure.persistance.jpa.entity.ProductEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Mapper para convertir dtos y entidades de un Producto
 */
@Mapper(componentModel = "spring")
public interface IProductMapper {

    /**
     * Convierte una entidad a un dto
     * @param productEntity Entidad a convertir
     * @return Dto convertido
     */
    Product toDto(ProductEntity productEntity);

    /**
     * Convierte un dto a una entidad
     * @param product Dto a convertir
     * @return Entidad convertida
     */
    ProductEntity toEntity(Product product);

    /**
     * Convierte una lista de entidades a una lista de dtos
     * @param products Lista de entidades a convertir
     * @return Lista de dtos convertidos
     */
    List<Product> toDtoList(List<ProductEntity> products);
}
