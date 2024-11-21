package be.nsi.labo.jpa.labojpa.domain.caracteristiques;

import be.nsi.labo.jpa.labojpa.domain.AbstractBaseAuditingEntity;
import be.nsi.labo.jpa.labojpa.domain.DossierEntity;
import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractCaracteristiqueEntity extends AbstractBaseAuditingEntity  {

    @Column(name = "identifiant", nullable = false)
    private String identifiant;

    @Column(name = "remarque_decision")
    private String remarqueDecision;

    @ManyToOne
    @JoinColumn(name = "form_status")
    private LovEntity formStatus;

    @ManyToOne
    @JoinColumn(name = "decision_status")
    private LovEntity decisionStatus;

    @ManyToOne
    @JoinColumn(name = "statut_en_vigueur")
    private LovEntity statutEnVigueur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dossier")
    private DossierEntity dossier;

    @Column (name = "importe")
    private Boolean importe;
}
