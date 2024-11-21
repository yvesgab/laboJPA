package be.nsi.labo.jpa.labojpa.domain.notifications;

import be.nsi.labo.jpa.labojpa.domain.*;
import be.nsi.labo.jpa.labojpa.domain.enums.DemandeurType;
import be.nsi.labo.jpa.labojpa.domain.enums.DossierRoute;
import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.CollectionUtils;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A NotificationEntity.
 */
@Entity
@Table(name = "notification")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationEntity extends AbstractBaseAuditingEntity implements Serializable {

    @Embedded
    private ValidationDGO4Entity validationDGO4;

    @Embedded
    private ValidationDirecteurEntity validationDirecteur;

    @Embedded
    private ValidationFTEntity validationFT;

    @Embedded
    private ValidationFDEntity validationFD;

    @Embedded
    private SignatureDirecteurEntity signatureDirecteur;

    @Embedded
    private SignatureCTEntity signatureCT;

    @Embedded
    private SignatureFTEntity signatureFT;

    @Embedded
    private SignatureFDEntity signatureFD;

    @Embedded
    private EnvoiNotificationEntity envoiNotification;

    @Embedded
    private ReponseNotificationEntity reponseNotification;

    @OrderBy("date DESC")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "notification_id")
    private Set<NotificationStatutEntity> statuts = new HashSet<>();

    @Transient
    public NotificationStatutEntity getLastStatut(){
        return CollectionUtils.isEmpty(statuts) ? null:statuts.iterator().next();
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "notification_id")
    private Set<NotificationSuiviEnvoiEntity> suiviEnvois = new HashSet<>();

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "type_notification", nullable = false)
    private TypeNotificationInstanceEntity typeNotification;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mode_envoi", columnDefinition = "varchar2(103)")
    private LovEntity modeEnvoi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mode_suivi", columnDefinition = "varchar2(103)")
    private LovEntity modeSuivi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "format_envoi", columnDefinition = "varchar2(103)")
    private LovEntity formatEnvoi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "langue", columnDefinition = "varchar2(103)")
    private LovEntity langue;

    @Column(name = "dossier", nullable = false)
    private Long dossier;

    @Column(name = "dossier_route")
    @Enumerated(EnumType.STRING)
    private DossierRoute dossierRoute;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contexte", columnDefinition = "varchar2(103)")
    private LovEntity contexte;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "extension", columnDefinition = "varchar2(103)")
    private LovEntity extension;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instance_type_code")
    private InstanceTypeEntity instanceType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_correspondant", columnDefinition = "varchar2(103)")
    private LovEntity typeCorrespondant;

    // NEW
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instance")
    private InstanceEntity instance;

    @Embedded
    private ExtensionCompletude1Entity completude1;

    @Embedded
    private ExtensionCompletude2Entity completude2;

    @Embedded
    private NotificationExtensionAvisInstanceEntity avisInstance;

    @Embedded
    private NotificationExtensionEnquetePublicEntity enquetePublic;

    @Embedded
    private NotificationExtensionAREntity accuseReception;

    @Embedded
    private NotificationExtensionDecisionEntity decision;

    @Embedded
    private NotificationExtensionRIPEntity rip;

    @Embedded
    private NotificationExtensionRapportSyntheseEntity rapportSynthese;

    // Demandeur

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dossier_demandeur_person")
    private DossierDemandeurPersonEntity dossierDemandeurPerson;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dossier_demandeur_enterprise")
    private DossierDemandeurEnterpriseEntity dossierDemandeurEnterprise;

    @Column(name = "type_demandeur", columnDefinition = "varchar2(103)")
    @Enumerated(EnumType.STRING)
    private DemandeurType typeDemandeur;

    @Column(name = "erreur_envoi")
    private Boolean erreurEnvoi;

}
