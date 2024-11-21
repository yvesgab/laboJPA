package be.nsi.labo.jpa.labojpa.domain.views;

import be.nsi.labo.jpa.labojpa.domain.AbstractBaseEntity;
import be.nsi.labo.jpa.labojpa.domain.LocalDateTimeConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.Immutable;

import java.time.LocalDateTime;

/**
 * A Dossier recherche view.
 */
@Entity
@Table(name = "dossier_recherche_view")
@Immutable
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class DossierRechercheView extends AbstractBaseEntity {

    @Column(name = "dgo3_direction")
    private Long dgo3Direction;

    @Column(name = "dgo3_direction_libelle")
    private String dgo3DirectionLibelle;

    @Column(name = "dgo4_direction")
    private Long dgo4Direction;

    @Column(name = "dgo4_direction_libelle")
    private String dgo4DirectionLibelle;

    @NonNull
    @Column(name = "dossier_type")
    private String dossierType;

    @NonNull
    @Column(name = "dossier_type_name")
    private String dossierTypeName;

    @Column(name = "dossier_type_fusionnable")
    private String dossierTypeFusionnable;

    @NonNull
    @Column(name = "numero_dossier")
    private String numDossier;

    @Column(name = "dgo3_fonctionnaire")
    private Long dgo3Fonctionnaire;

    @Column(name = "dgo3_contact_admin")
    private Long dgo3ContactAdmin;

    @Column(name = "dgo3_contact_admin_fullname")
    private String dgo3ContactAdminFullName;

    @Column(name = "dgo3_contact_tech")
    private Long dgo3ContactTech;

    @Column(name = "dgo3_contact_tech_fullname")
    private String dgo3ContactTechFullName;

    @Column(name = "dgo4_fonctionnaire")
    private Long dgo4Fonctionnaire;

    @Column(name = "dgo4_contact_admin")
    private Long dgo4ContactAdmin;

    @Column(name = "dgo4_contact_tech")
    private Long dgo4ContactTech;

    @Column(name = "nom_exploitant")
    private String nomExploitant;

    @Column(name = "nom_solliciteur")
    private String nomSolliciteur;

    @Column(name = "etablissement_numero_bce")
    private String etablissementNumBce;

    @Column(name = "etablissement_rue")
    private String etablissementRue;

    @Column(name = "etablissement_numero")
    private String etablissementNum;

    @Column(name = "etablissement_localite_id")
    private Long etablissementLocaliteId;

    @Column(name = "etablissement_adresse")
    private String etablissementAdresse;

    @Column(name = "etablissement_nom")
    private String etablissementNom;

//    @Column(name = "etablissement_coordonnee_lambert_x")
//    private Integer etablissementCoordLambX;
//
//    @Column(name = "etablissement_coordonnee_lambert_y")
//    private Integer etablissementCoordLambY;

    @Column(name = "etablissement_affecte")
    private boolean etablissementAffecte;

    @Column(name = "commune_depot_fr")
    private String communeDepotFr;

    @Column(name = "commune_depot_de")
    private String communeDepotDe;

    @Column(name = "objet_demande", columnDefinition="TEXT")
    private String objetDemande;

    @Column(name = "electronic_form_number")
    private String refFormulaire;

    @Column(name = "rubrique")
    private String rubrique;

    @Column(name = "date_creation")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime dateCreation;

    @Column(name = "date_decision")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime dateDecision;

    //private String parcelle;

    @Column(name = "dossier_fussionne")
    private boolean dossierFussionne;

}
