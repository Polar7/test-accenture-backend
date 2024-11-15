package co.com.accenture.testaccenturebackend.domain.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Modelo que representa un Producto de una {@link Branch}
 */
@Getter
@Setter
public class Product {

    /**
     * Id del producto
     */
    private Long id;

    /**
     * Nombre del producto
     */
    private String name;

    /**
     * Unidades disponibles del producto
     */
    private Long stock;

    /**
     * Id de la sucursal donde se encuentra el producto
     */
    private Long branchId;
}
