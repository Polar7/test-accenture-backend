package co.com.accenture.testaccenturebackend.domain.usecase;

import co.com.accenture.testaccenturebackend.application.dto.GenericDtoResponse;
import co.com.accenture.testaccenturebackend.application.dto.SaveFranchiseDtoRequest;
import co.com.accenture.testaccenturebackend.application.dto.UpdateFranchiseDtoRequest;
import co.com.accenture.testaccenturebackend.domain.model.Franchise;

import java.util.List;

/**
 * Puerto para los casos de uso de una Franquicia
 */
public interface IFranchiseUseCasePort {

    /**
     * Devuelve todas las franquicias
     * @return Lista con las franquicias existentes
     */
    List<Franchise> findAllFranchises();

    /**
     * Guarda una nueva franquicia
     * @param dtoNewFranchise Dto de la franquicia a crear
     * @return Dto con respuesta de la operacion
     */
    GenericDtoResponse saveFranchise(SaveFranchiseDtoRequest dtoNewFranchise);

    /**
     * Modifica el nombre de una franquicia existente
     * @param dtoUpdateFranchise Franquicia a editar
     * @return Dto con respuesta de la operacion
     */
    GenericDtoResponse updateFranchise(UpdateFranchiseDtoRequest dtoUpdateFranchise);
}
