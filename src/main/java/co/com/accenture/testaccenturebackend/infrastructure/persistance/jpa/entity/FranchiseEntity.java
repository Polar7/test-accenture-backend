package co.com.accenture.testaccenturebackend.infrastructure.persistance.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Entidad que representa una Franquicia
 */
@Getter
@Setter
@Entity
@Table(name = "franchise")
public class FranchiseEntity {

    /**
     * Id de la franquicia
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de la franquicia
     */
    private String name;

    /**
     * Lista de Sucursales que pertenecen a la franquicia
     */
    @OneToMany(mappedBy = "franchiseId")
    private List<BranchEntity> branches;
}
