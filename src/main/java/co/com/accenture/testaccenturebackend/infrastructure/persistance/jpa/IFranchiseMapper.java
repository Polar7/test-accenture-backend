package co.com.accenture.testaccenturebackend.infrastructure.persistance.jpa;

import co.com.accenture.testaccenturebackend.domain.model.Franchise;
import co.com.accenture.testaccenturebackend.infrastructure.persistance.jpa.entity.FranchiseEntity;
import org.mapstruct.Mapper;

/**
 * Mapper para convertir dtos y entidades de una Franquicia
 */
@Mapper(componentModel = "spring")
public interface IFranchiseMapper {

    /**
     * Convierte una entidad a un dto
     * @param franchiseEntity Entidad a convertir
     * @return Dto convertido
     */
    Franchise toDto(FranchiseEntity franchiseEntity);

    /**
     * Convierte un dto a una entidad
     * @param franchise Dto a convertir
     * @return Entidad convertida
     */
    FranchiseEntity toEntity(Franchise franchise);
}
