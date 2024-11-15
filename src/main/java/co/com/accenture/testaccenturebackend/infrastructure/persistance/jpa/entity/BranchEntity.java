package co.com.accenture.testaccenturebackend.infrastructure.persistance.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Entidad que representa una Sucursal de una {@link FranchiseEntity}
 */
@Getter
@Setter
@Entity
@Table(name = "branch")
public class BranchEntity {

    /**
     * Id de la sucursal
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Id de la Franquicia a la que pertenece la sucursal
     */
    @Column(name = "id_franchise")
    private Long franchiseId;

    /**
     * Nombre de la sucursal
     */
    private String name;

    /**
     * Lista de Productos que se encuentran en la sucursal
     */
    @OneToMany(mappedBy = "branchEntity")
    private List<ProductEntity> products;

    /**
     * Relacion con la entidad Franquicia
     */
    @ManyToOne
    @JoinColumn(name = "id_franchise", insertable = false, updatable = false)
    private FranchiseEntity franchiseEntity;
}
