package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.referentiels.RubriqueEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

/**
 * A RubriqueCaracteristiqueEntity.
 */
@Entity
@Table(name = "rubrique_caracteristique")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RubriqueCaracteristiqueEntity extends AbstractBaseAuditingEntity implements AuditingEntity {

    @ManyToOne()
    @JoinColumn(name = "id_etablissement")
    @NotNull
    private EtablissementEntity etablissement;

    @ManyToOne()
    @JoinColumn(name = "id_rubrique")
    @NotNull
    private RubriqueEntity rubrique;

    @Column(name = "code_caracteristique")
    @NotNull
    private String codeCaracteristique;

    @Column(name = "libelle_caracteristique")
    @NotNull
    private String libelleCaracteristique;

}
