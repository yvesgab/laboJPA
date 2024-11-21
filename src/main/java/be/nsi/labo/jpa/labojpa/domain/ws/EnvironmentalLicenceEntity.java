package be.nsi.labo.jpa.labojpa.domain.ws;

import be.nsi.labo.jpa.labojpa.domain.AbstractBaseAuditingEntity;
import be.nsi.labo.jpa.labojpa.domain.AuditingEntity;
import be.nsi.labo.jpa.labojpa.domain.DossierTypeEntity;
import be.nsi.labo.jpa.labojpa.domain.InstanceEntity;
import be.nsi.labo.jpa.labojpa.domain.referentiels.CommuneEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "environmental_licence")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnvironmentalLicenceEntity extends AbstractBaseAuditingEntity implements Serializable, AuditingEntity {

    @Column(name = "environmental_licence_payload", columnDefinition = "TEXT")
    private String environmentalLicencePayload;

    @Column(name = "nep_datastore", columnDefinition = "TEXT")
    private String dataStore;

    @Column(name = "nep_payload", columnDefinition = "TEXT")
    private String nepPayload;

    @Column(name = "numero_dossier")
    private String numeroDossier;

    @Column(name = "numero_formulaire")
    private String numeroFormulaire;

    @Column(name = "type_formulaire")
    private String typeFormulaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dgo3_direction")
    private InstanceEntity dgo3Direction;

    @ManyToOne
    @JoinColumn(name = "type_dossier", foreignKey = @ForeignKey(name = "environmental_licence_fk_dossier_type"))
    private DossierTypeEntity typeDossier;

    @Column(name = "exploitants", columnDefinition = "TEXT")
    private String exploitants;

    @ManyToOne
    @JoinColumn(name = "commune_depot", foreignKey = @ForeignKey(name = "environmental_licence_fk_commune_depot"))
    private CommuneEntity communeDepot;

    @Column(name = "nom_etablissements", columnDefinition = "TEXT")
    private String nomEtablissements;

    @Column(name = "numero_bce_etablissements", columnDefinition = "TEXT")
    private String numeroBceEtablissements;

    @Column(name = "adresse_etablissements", columnDefinition = "TEXT")
    private String adresseEtablissements;

    @Column(name = "commune_date_envoi")
    private LocalDateTime dateEnvoi;

    @Column(name = "commune_date_reception")
    private LocalDateTime dateReception;

    @Column(name = "date_reception_piece_jointe")
    private LocalDateTime dateReceptionPieceJointe;

    @Column(name = "date_modification_statut_nep")
    private LocalDateTime dateModificationStatutNep;

    @Column(name = "commune_date_reponse")
    private LocalDateTime dateReponse;

    @Column(name = "notice_id")
    private String noticeId;

    @Column(name = "etape")
    private String etape;

    @Column(name = "code_erreur")
    private String codeErreur;

    @Column(name = "message_erreur", columnDefinition = "TEXT")
    private String messageErreur;

    @Column(name = "in_progress", nullable = false, columnDefinition = "boolean default false")
    private boolean inProgress = false;

    @Column(name = "hide", columnDefinition = "boolean default false")
    private boolean hide;

    @Override
    public String toString() {
        return "EnvironmentalLicenceEntity: {" +
            "\n\n   environmentalLicencePayload : " + environmentalLicencePayload +
            "\n\n   dataStore : " + dataStore +
            "\n\n   nepPayload : " + nepPayload +
            "\n\n   numeroDossier : " + numeroDossier +
            "\n\n   numeroFormulaire : " + numeroFormulaire +
            "\n\n   typeFormulaire : " + typeFormulaire +
            "\n\n   dgo3Direction : " + dgo3Direction +
            "\n\n   typeDossier : " + typeDossier +
            "\n\n   exploitants : " + exploitants +
            "\n\n   communeDepot : " + communeDepot +
            "\n\n   nomEtablissements : " + nomEtablissements +
            "\n\n   numeroBceEtablissements : " + numeroBceEtablissements +
            "\n\n   adresseEtablissements : " + adresseEtablissements +
            "\n\n   dateEnvoi : " + dateEnvoi +
            "\n\n   dateReception : " + dateReception +
            "\n\n   dateReceptionPieceJointe : " + dateReceptionPieceJointe +
            "\n\n   dateModificationStatutNep : " + dateModificationStatutNep +
            "\n\n   dateReponse : " + dateReponse +
            "\n\n   noticeId : " + noticeId +
            "\n\n   etape : " + etape +
            "\n\n   codeErreur : " + codeErreur +
            "\n\n   messageErreur : " + messageErreur +
            "\n\n   inProgress : " + inProgress +
            "\n}";
    }
}
