package co.com.accenture.testaccenturebackend.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Modelo que representa una Sucursal de una {@link Franchise}
 */
@Getter
@Setter
public class Branch {

    /**
     * Id de la sucursal
     */
    private Long id;

    /**
     * Nombre de la sucursal
     */
    private String name;

    /**
     * Lista de Productos que se encuentran en la sucursal
     */
    private List<Product> products;

    /**
     * Id de la Franquicia a la que pertenece la sucursal
     */
    private Long franchiseId;
}
