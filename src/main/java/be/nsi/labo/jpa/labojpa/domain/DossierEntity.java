package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.echeanciers.EcheancierEntity;
import be.nsi.labo.jpa.labojpa.domain.echeanciers.EcheancierGrilleDelaiEntity;
import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import be.nsi.labo.jpa.labojpa.domain.referentiels.CommuneEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * A Dossier.
 */
@Entity
@Table(name = "dossier")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DossierEntity extends AbstractBaseAuditingEntity implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dossier_type_name", nullable = false)
    private DossierTypeEntity dossierTypeEntity;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_dossier")
    private List<DossierEtablissementEntity> etablissements;

    @Column(name = "numero_dossier", nullable = false, updatable = false)
    private String numeroDossier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statut_carto")
    private LovEntity statutCarto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language")
    private LovEntity language;

    @Column(name = "date_envoidemandeur")
    private LocalDate dateEnvoiDemandeur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commune_depot")
    private CommuneEntity communeDepot;

    @Column(name = "commune_reception")
    private LocalDate communeReception;

    @Column(name = "commune_reference")
    private String communeReference;

    @Column(name = "commune_intervenant")
    private String communeIntervenant;

    @Column(name = "commune_dpa")
    private LocalDate communeDpa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dgo3_direction")
    private InstanceEntity dgo3Direction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dgo3_fonctionnaire")
    private UserTwiceEntity dgo3Fonctionnaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dgo3_directeur")
    private UserTwiceEntity dgo3Directeur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dgo3_contact_admin")
    private UserTwiceEntity dgo3ContactAdmin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dgo3_contact_tech")
    private UserTwiceEntity dgo3ContactTech;

    @Column(name = "dgo3_reception")
    private LocalDate dgo3Reception;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dgo4_direction")
    private InstanceEntity dgo4Direction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dgo4_fonctionnaire")
    private UserTwiceEntity dgo4Fonctionnaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dgo4_directeur")
    private UserTwiceEntity dgo4Directeur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dgo4_contact_admin")
    private UserTwiceEntity dgo4ContactAdmin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dgo4_contact_tech")
    private UserTwiceEntity dgo4ContactTech;

    @Column(name = "dgo4_reference")
    private String dgo4Reference;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_permis")
    private LovEntity typePermis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classe")
    private LovEntity classe;

    @Column(name = "objet_demande", columnDefinition = "TEXT")
    private String objetDemande;

    @Column(name = "objet_dpa_fr", columnDefinition = "TEXT")
    private String objetDpaFr;

    @Column(name = "objet_dpa_de", columnDefinition = "TEXT")
    private String objetDpaDe;

    @Column(name = "modification_voirie")
    private Boolean modificationVoirie;

    @Column(name = "eie")
    private Boolean eie;

    @Column(name = "seveso")
    private Boolean seveso;

    @Column(name = "assainissement")
    private Boolean assainissement;

    @Column(name = "essai")
    private Boolean essai;

    @Column(name = "mobile")
    private Boolean mobile;

    @Column(name = "temporaire")
    private Boolean temporaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autorite")
    private LovEntity autorite;

    @Column(name = "plusieurs_communes")
    private Boolean plusieursCommunes;

    @Column(name = "codt")
    private Boolean codt;

    @Column(name = "decret_sol")
    private Boolean decretSol;

    @Column(name = "igd")
    private Boolean igd;

    @Column(name = "commune_exploitant")
    private Boolean communeExploitant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "duree_permis")
    private LovEntity dureePermis;

    @Column(name = "fin_permis")
    private LocalDate finPermis;

    @Column(name = "duree_jours")
    private Integer dureeJours;

    @Column(name = "duree_mois")
    private Integer dureeMois;

    @Column(name = "duree_annees")
    private Integer dureeAnnees;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_formulaire")
    private LovEntity typeFormulaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "echeancier")
    private EcheancierEntity echeancier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "echeancier_grille_delai")
    private EcheancierGrilleDelaiEntity echeancierGrilleDelai;

    @Column(name = "derniere_modification")
    private Date derniereModification;

    @Column(name = "dernier_calcul")
    private Date dernierCalcul;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "frequence_calcul")
    private LovEntity frequenceCalcul;

    @Embedded
    private ElectronicFormEntity electronicForm;

    @Column(name = "donnees_confidentielles")
    private Boolean donneesConfidentielles;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statut_archivage")
    private LovEntity statutArchivage;

    @Override
    public String toString() {
        return "DossierEntity{" +
            "dossierTypeEntity=" + dossierTypeEntity +
            ", etablissements=" + etablissements +
            ", numeroDossier='" + numeroDossier + '\'' +
            ", statutCarto=" + statutCarto +
            ", language=" + language +
            ", dateEnvoiDemandeur=" + dateEnvoiDemandeur +
            ", communeDepot=" + communeDepot +
            ", communeReception=" + communeReception +
            ", communeReference='" + communeReference + '\'' +
            ", communeIntervenant='" + communeIntervenant + '\'' +
            ", communeDpa=" + communeDpa +
            ", dgo3Direction=" + dgo3Direction +
            ", dgo3Fonctionnaire=" + dgo3Fonctionnaire +
            ", dgo3Directeur=" + dgo3Directeur +
            ", dgo3ContactAdmin=" + dgo3ContactAdmin +
            ", dgo3ContactTech=" + dgo3ContactTech +
            ", dgo3Reception=" + dgo3Reception +
            ", dgo4Direction=" + dgo4Direction +
            ", dgo4Fonctionnaire=" + dgo4Fonctionnaire +
            ", dgo4Directeur=" + dgo4Directeur +
            ", dgo4ContactAdmin=" + dgo4ContactAdmin +
            ", dgo4ContactTech=" + dgo4ContactTech +
            ", dgo4Reference='" + dgo4Reference + '\'' +
            ", typePermis=" + typePermis +
            ", classe=" + classe +
            ", objetDemande='" + objetDemande + '\'' +
            ", objetDpaFr='" + objetDpaFr + '\'' +
            ", objetDpaDe='" + objetDpaDe + '\'' +
            ", modificationVoirie=" + modificationVoirie +
            ", eie=" + eie +
            ", seveso=" + seveso +
            ", assainissement=" + assainissement +
            ", essai=" + essai +
            ", mobile=" + mobile +
            ", temporaire=" + temporaire +
            ", autorite=" + autorite +
            ", plusieursCommunes=" + plusieursCommunes +
            ", codt=" + codt +
            ", decretSol=" + decretSol +
            ", igd=" + igd +
            ", communeExploitant=" + communeExploitant +
            ", dureePermis=" + dureePermis +
            ", finPermis=" + finPermis +
            ", dureeJours=" + dureeJours +
            ", dureeMois=" + dureeMois +
            ", dureeAnnees=" + dureeAnnees +
            ", typeFormulaire=" + typeFormulaire +
            ", echeancier=" + echeancier +
            ", echeancierGrilleDelai=" + echeancierGrilleDelai +
            ", derniereModification=" + derniereModification +
            ", dernierCalcul=" + dernierCalcul +
            ", frequenceCalcul=" + frequenceCalcul +
            ", electronicForm=" + electronicForm +
            ", donneesConfidentielles=" + donneesConfidentielles +
            ", statutArchivage=" + statutArchivage +
            '}';
    }
}
