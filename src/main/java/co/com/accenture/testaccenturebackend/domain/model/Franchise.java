package co.com.accenture.testaccenturebackend.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Modelo que representa una Franquicia
 */
@Getter
@Setter
public class Franchise {

    /**
     * Id de la franquicia
     */
    private Long id;

    /**
     * Nombre de la franquicia
     */
    private String name;

    /**
     * Lista de Sucursales que pertenecen a la franquicia
     */
    private List<Branch> branches;
}
