package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import be.nsi.labo.jpa.labojpa.domain.referentiels.RubriqueEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A DossierRubriqueEntity.
 */
@Entity
@Table(name = "dossier_rubrique", uniqueConstraints =
@UniqueConstraint(columnNames = {"rubrique", "dossier"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DossierRubriqueEntity extends AbstractBaseAuditingEntity implements AuditingEntity {

    @ManyToOne
    @JoinColumn(name = "rubrique", nullable = false)
    private RubriqueEntity rubrique;

    @ManyToOne
    @JoinColumn(name = "dossier", nullable = false)
    private DossierEntity dossier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statut")
    private LovEntity statut;

}
