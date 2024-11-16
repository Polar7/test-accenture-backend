package co.com.accenture.testaccenturebackend.infrastructure.persistance.jpa.repository;

import co.com.accenture.testaccenturebackend.domain.model.Franchise;
import co.com.accenture.testaccenturebackend.domain.repository.IFranchiseRepositoryPort;
import co.com.accenture.testaccenturebackend.infrastructure.persistance.jpa.mapper.IFranchiseMapper;
import co.com.accenture.testaccenturebackend.infrastructure.persistance.jpa.crud.IFranchiseCrudRepository;
import co.com.accenture.testaccenturebackend.infrastructure.persistance.jpa.entity.FranchiseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Adaptador para las operaciones del repositorio de una Franquicia
 */
@Repository
@RequiredArgsConstructor
public class FranchiseRepositoryAdapter implements IFranchiseRepositoryPort {

    /**
     * Interfaz crud de franquicia
     */
    private final IFranchiseCrudRepository franchiseCrudRepository;

    /**
     * Mapper de franquicia
     */
    private final IFranchiseMapper franchiseMapper;

    /**
     * Devuelve todas las franquicias
     * @return Lista con las franquicias existentes
     */
    @Override
    public List<Franchise> findAllFranchises() {
        return franchiseCrudRepository.findAll()
                .stream()
                .map(franchiseMapper::toDto)
                .toList();
    }

    /**
     * Encuentra una franquicia dado su id
     * @param id Id a buscar
     * @return Optional con la franquicia encontrada
     */
    @Override
    public Optional<Franchise> findFranchiseById(Long id) {
        return franchiseCrudRepository.findById(id).map(franchiseMapper::toDto);
    }

    /**
     * Encuentra una franquicia dado su nombre
     * @param name Nombre a buscar
     * @return Optional con la franquicia encontrada
     */
    @Override
    public Optional<Franchise> findFranchiseByName(String name) {
        return franchiseCrudRepository.findByName(name).map(franchiseMapper::toDto);
    }

    /**
     * Guarda una nueva franquicia
     * @param nameNewfranchise Nombre de la nueva franquicia a crear
     * @return Franquicia creada
     */
    @Override
    public Franchise saveFranchise(String nameNewfranchise) {
        FranchiseEntity newEntity = new FranchiseEntity();
        newEntity.setName(nameNewfranchise);
        return franchiseMapper.toDto(franchiseCrudRepository.save(newEntity));
    }

    /**
     * Modifica una franquicia
     * @param franchise Franquicia a editar
     * @return Franquicia actualizada
     */
    @Override
    public Franchise updateFranchise(Franchise franchise) {
        return franchiseMapper.toDto(
                franchiseCrudRepository.save(franchiseMapper.toEntity(franchise))
        );
    }
}
