package be.nsi.labo.jpa.labojpa.domain.notifications;

import be.nsi.labo.jpa.labojpa.domain.AbstractAuditingEntity;
import be.nsi.labo.jpa.labojpa.domain.DocumentTypeEntity;
import be.nsi.labo.jpa.labojpa.domain.DossierTypeEntity;
import be.nsi.labo.jpa.labojpa.domain.InstanceTypeEntity;
import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractTypeNotificationEntity extends AbstractAuditingEntity implements Serializable {

    @Column(name = "_order")
    private Long order;

    @Column(name = "libelle_fr")
    private String libelleFr;

    @Column(name = "libelle_de")
    private String libelleDe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contexte", columnDefinition = "varchar2(103)")
    private LovEntity contexte;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "extension", columnDefinition = "varchar2(103)")
    private LovEntity extension;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_correspondant", columnDefinition = "varchar2(103)")
    private LovEntity typeCorrespondant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "processus_associe", columnDefinition = "varchar2(103)")
    private LovEntity processusAssocie;

    @ManyToOne
    @JoinColumn(name = "type_document")
    private DocumentTypeEntity typeDocument;

    @Column(name = "signer_originaux")
    private Boolean signerOriginaux;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dossier_type")
    private DossierTypeEntity dossierType;

    @ManyToOne
    @JoinColumn(name = "instance_type_code")
    private InstanceTypeEntity typeInstance;

    @ManyToOne
    @JoinColumn(name = "modele_notification", columnDefinition = "varchar2(255)")
    private ModeleNotificationEntity modele;

    @Column(name = "finaliser")
    private Boolean finaliser;

    @Column(name = "valider_FT")
    private Boolean validerFT;

    @Column(name = "signer_FT")
    private Boolean signerFT;

    @Column(name = "valider_FD_PU")
    private Boolean validerFDPU;

    @Column(name = "signer_FD_PU")
    private Boolean signerFDPU;

    @Column(name = "signer_CT")
    private Boolean signerCT;

    @Column(name = "valider_directeur")
    private Boolean validerDirecteur;

    @Column(name = "signer_directeur")
    private Boolean signerDirecteur;

    @Column(name = "signatures_electroniques")
    private Boolean signaturesElectroniques;

    @Column(name = "date_envoi_notification")
    private Boolean dateEnvoiNotification;

    @Column(name = "date_AR")
    private Boolean dateAR;

    @Column(name = "reponse_attendue")
    private Boolean reponseAttendue;

    @Column(name = "date_envoi")
    private Boolean dateEnvoi;

    @Column(name = "date_reception_reponse_commune")
    private Boolean dateReceptionReponseCommune;

    @Column(name = "date_reception_reponse_DPA")
    private Boolean dateReceptionReponseDPA;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_permis", columnDefinition = "varchar2(103)")
    private LovEntity typePermis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "decision_completude_1_tour_instance", columnDefinition = "varchar2(103)")
    private LovEntity decisionCompletude1TourInstance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "decision_completude_1_tour_avis_coordonne_1", columnDefinition = "varchar2(103)")
    private LovEntity decisionCompletude1TourAvisCoordonne1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "decision_completude_1_tour_avis_coordonne_2", columnDefinition = "varchar2(103)")
    private LovEntity decisionCompletude1TourAvisCoordonne2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "decision_completude_2_tour_avis_coordonne_1", columnDefinition = "varchar2(103)")
    private LovEntity decisionCompletude2TourAvisCoordonne1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "decision_completude_2_tour_avis_coordonne_2", columnDefinition = "varchar2(103)")
    private LovEntity decisionCompletude2TourAvisCoordonne2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "decision_completude_1_tour_avis_coordonne", columnDefinition = "varchar2(103)")
    private LovEntity decisionCompletude1TourAvisCoordonne;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "decision_completude_2_tour_avis_coordonne", columnDefinition = "varchar2(103)")
    private LovEntity decisionCompletude2TourAvisCoordonne;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mode_suivi")
    private LovEntity modeSuivi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "format_envoi")
    private LovEntity formatEnvoi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "choix_langue", nullable = false)
    private LovEntity choixLangue;

    @Column(name = "valider_dgo4_fd")
    private Boolean validerDGO4FD;

    @Column(name = "envoi_fin_etape")
    private String envoiFinEtape;

    @Column(name = "selection_manuelle")
    private Boolean selectionManuelle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ac_dpa"/*, foreignKey = @ForeignKey(name = "type_notification_fk_ac_dpa")*/)
    private LovEntity acDpa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "envoi_retard"/*, foreignKey = @ForeignKey(name = "type_notification_fk_envoi_retard")*/)
    private LovEntity envoiRetard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rs_non_envoie"/*, foreignKey = @ForeignKey(name = "type_notification_fk_rs_non_envoie")*/)
    private LovEntity rsNonEnvoie;

    @Column(name = "demande_complement")
    private Boolean demandeComplement;

    @Column(name = "cloture_dossier_nep")
    private Boolean clotureDossierNep;

    @Column(name = "envoi_numero_rn")
    private Boolean envoiNumeroRn;

    @Column(name = "confirmation_envoi_electronique")
    private Boolean confirmationEnvoiElectronique;
}
