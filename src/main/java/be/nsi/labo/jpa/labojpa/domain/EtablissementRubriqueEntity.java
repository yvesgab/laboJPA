package be.nsi.labo.jpa.labojpa.domain;


import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import be.nsi.labo.jpa.labojpa.domain.referentiels.RubriqueEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.*;

/**
 * A EtablissementRubrique.
 */
@Entity
@Table(name = "etablissement_rubrique", uniqueConstraints =
@UniqueConstraint(columnNames = {"rubrique", "etablissement"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class EtablissementRubriqueEntity extends AbstractBaseAuditingEntity implements AuditingEntity {

    @ManyToOne
    @JoinColumn(name = "rubrique", nullable = false)
    private RubriqueEntity rubrique;

    @ManyToOne
    @JoinColumn(name = "etablissement", nullable = false)
    private EtablissementEntity etablissement;

    @ManyToOne
    @JoinColumn(name = "statut")
    private LovEntity statut;

    @Column(name = "activite_principale", columnDefinition = "boolean default false")
    private boolean activitePrincipale;
}
