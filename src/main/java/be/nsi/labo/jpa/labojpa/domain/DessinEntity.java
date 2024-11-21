package be.nsi.labo.jpa.labojpa.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * The type Dessin entity.
 */
@Entity
@Table(name = "dessin")
@Getter     // Lombok
@Setter     // Lombok
@NoArgsConstructor      // Lombok
@AllArgsConstructor     // Lombok
public class DessinEntity extends AbstractBaseAuditingEntity implements Serializable, AuditingEntity {

    /**
     * The Dossier.
     */
    @ManyToOne
    @JoinColumn(name = "dossier", nullable = false)
    private DossierEntity dossier;

    /**
     * The Json.
     */
    @Column(name = "json")
    private String json;
}
