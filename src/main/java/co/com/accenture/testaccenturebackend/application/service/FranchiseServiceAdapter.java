package co.com.accenture.testaccenturebackend.application.service;

import co.com.accenture.testaccenturebackend.application.dto.GenericDtoResponse;
import co.com.accenture.testaccenturebackend.application.dto.SaveFranchiseDtoRequest;
import co.com.accenture.testaccenturebackend.application.dto.UpdateFranchiseDtoRequest;
import co.com.accenture.testaccenturebackend.domain.model.Franchise;
import co.com.accenture.testaccenturebackend.domain.repository.IFranchiseRepositoryPort;
import co.com.accenture.testaccenturebackend.domain.usecase.IFranchiseUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FranchiseServiceAdapter implements IFranchiseUseCasePort {

    /**
     * Repositorio de franquicia
     */
    private final IFranchiseRepositoryPort franchiseRepository;

    /**
     * Devuelve todas las franquicias
     * @return Lista con las franquicias existentes
     */
    @Override
    public List<Franchise> findAllFranchises() {
        return franchiseRepository.findAllFranchises();
    }

    /**
     * Guarda una nueva franquicia
     * @param dtoNewFranchise Dto de la franquicia a crear
     * @return Dto con respuesta de la operacion
     * @exception RuntimeException Si ya existe una franquicia con el mismo nombre
     */
    @Override
    public GenericDtoResponse saveFranchise(SaveFranchiseDtoRequest dtoNewFranchise) {

        if (franchiseRepository.findFranchiseByName(dtoNewFranchise.getName()).isPresent()) {
            throw new RuntimeException("Ya existe una Franquicia con el nombre ingresado");
        }

        franchiseRepository.saveFranchise(dtoNewFranchise.getName());
        return GenericDtoResponse.builder().code(0).message("Guardado existoso de la nueva franquicia.").build();
    }

    /**
     * Modifica el nombre de una franquicia existente
     * @param dtoUpdateFranchise Franquicia a editar
     * @return Dto con respuesta de la operacion
     * @exception RuntimeException Si ya existe una franquicia con el mismo nombre
     * @exception RuntimeException Si no existe una franquicia con el id dado
     */
    @Override
    public GenericDtoResponse updateFranchise(UpdateFranchiseDtoRequest dtoUpdateFranchise) {

        if (franchiseRepository.findFranchiseByName(dtoUpdateFranchise.getName()).isPresent()) {
            throw new RuntimeException("Ya existe una franquicia con ese nombre.");
        }

        Optional<Franchise> modifyFranchise = franchiseRepository.findFranchiseById(dtoUpdateFranchise.getId());

        if (modifyFranchise.isEmpty()) {
            throw new RuntimeException("No existe una franquicia con el id dado.");
        }

        franchiseRepository.updateFranchise(
                modifyFranchise.map(x -> {
                    x.setName(dtoUpdateFranchise.getName());
                    return x;
                }).get()
        );

        return GenericDtoResponse.builder().code(0).message("Modificacion existosa del nombre de la franquicia.").build();
    }
}