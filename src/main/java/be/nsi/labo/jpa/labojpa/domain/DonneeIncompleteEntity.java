package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A DonneeIncompleteEntity.
 */

@Entity
@Table(name = "donnee_incomplete")
@Getter     // Lombok
@Setter     // Lombok
@NoArgsConstructor      // Lombok
@AllArgsConstructor     // Lombok
public class DonneeIncompleteEntity extends AbstractBaseAuditingEntity implements AuditingEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "champ", nullable = false)
    private LovEntity champ;

    @Column(name = "commentaire", columnDefinition = "TEXT")
    private String commentaire;

    @ManyToOne
    @JoinColumn(name = "dossier")
    private DossierEntity dossier;

}
