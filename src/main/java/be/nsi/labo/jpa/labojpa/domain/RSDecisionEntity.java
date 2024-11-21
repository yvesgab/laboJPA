package be.nsi.labo.jpa.labojpa.domain;


import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * A RSDecision.
 */
@Entity
@Table(name = "rs_decision")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RSDecisionEntity extends AbstractBaseAuditingEntity implements Serializable {

    @Column(name = "date_decision")
    private Date dateDecision;

    @Column(name = "date_debut_permis")
    private Date dateDebutPermis;

    @Column(name = "date_fin_permis")
    private Date dateFinPermis;

    @Column(name = "envoi_en_retard")
    private Boolean envoiEnRetard;

    @Column(name = "rs_non_envoye")
    private Boolean rsNonEnvoye;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statut_decision", columnDefinition = "varchar2(103)")
    private LovEntity statutDecision;

    @ManyToOne(fetch = FetchType.LAZY)
    //see LovDomCodes.DECISION_PERMIS
    @JoinColumn(name = "decision", columnDefinition = "varchar2(103)")
    private LovEntity decision;

    @ManyToOne
    @JoinColumn(name = "dossier", unique = true)
    private DossierEntity dossier;

    @Column(name = "surete_requise", columnDefinition = "boolean default false")
    private Boolean sureteRequise;

    @Column(name = "date_constitution_surete")
    private Date dateConstitutionSurete;

    @Column(name = "date_reception_decision")
    private Date dateReceptionDecision;

    @Column(name = "date_transmission_decision")
    private Date dateTransmissionDecision;

    @Column(name = "permis_implemente")
    private Boolean permisImplemente;

    @Column(name = "date_implementation_permis")
    private Date dateImplementationPermis;

}
