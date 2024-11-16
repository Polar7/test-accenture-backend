package co.com.accenture.testaccenturebackend.infrastructure.persistance.jpa.mapper;

import co.com.accenture.testaccenturebackend.domain.model.Branch;
import co.com.accenture.testaccenturebackend.infrastructure.persistance.jpa.entity.BranchEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Mapper para convertir dtos y entidades de una Sucursal
 */
@Mapper(componentModel = "spring")
public interface IBranchMapper {

    Branch toDto(BranchEntity branchEntity);

    BranchEntity toEntity(Branch branch);

    List<Branch> toDtoList(List<BranchEntity> branchEntities);
}
