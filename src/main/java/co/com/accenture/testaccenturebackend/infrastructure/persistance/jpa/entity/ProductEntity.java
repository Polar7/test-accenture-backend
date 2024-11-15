package co.com.accenture.testaccenturebackend.infrastructure.persistance.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad que representa un Producto de una {@link BranchEntity}
 */
@Getter
@Setter
@Entity
@Table(name = "product")
public class ProductEntity {

    /**
     * Id del producto
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Id de la sucursal donde se encuentra el producto
     */
    @Column(name = "id_branch")
    private Long branchId;

    /**
     * Nombre del producto
     */
    private String name;

    /**
     * Unidades disponibles del producto
     */
    private Long stock;

    /**
     * Relacion con la entidad Sucursal
     */
    @ManyToOne
    @JoinColumn(name = "id_branch", insertable = false, updatable = false)
    private BranchEntity branchEntity;
}
