package be.nsi.labo.jpa.labojpa.domain;


import be.nsi.labo.jpa.labojpa.domain.notifications.NotificationEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * A DossierConditionParticuliereEntity.
 */
@Entity
@Table(name = "dossier_condition_particuliere", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"bloc", "code"}, name = "dossier_condition_particuliere_unique_bloc_code")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DossierConditionParticuliereEntity extends AbstractBaseAuditingEntity implements AuditingEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bloc")
    private DossierBlocEntity bloc;

    @Column(name = "code")
    private String code;

    @Column(name = "libelle_fr")
    private String libelleFr;

    @Column(name = "libelle_de")
    private String libelleDe;

    @Column(name = "texte_fr", columnDefinition = "TEXT")
    private String texteFr;

    @Column(name = "texte_de", columnDefinition = "TEXT")
    private String texteDe;

    @JoinColumn(name = "adapte")
    private Boolean adapte; // Dans le RS

    @JoinColumn(name = "rubr_cl_val_txt")
    private String rubrClValTxt;

    @ManyToMany
    @OrderBy("identifiant asc")
    @JoinTable(name = "dossier_condition_particuliere_parcelles",
        uniqueConstraints = @UniqueConstraint(columnNames = {"dossier_condition_particuliere_id", "parcelle_id"}, name = "dossier_condition_particuliere_parcelles_pkey"),
        joinColumns = {@JoinColumn(name = "dossier_condition_particuliere_id")},
        inverseJoinColumns = {@JoinColumn(name = "parcelle_id")}
    )
    private List<ParcelleEntity> parcelles;

    @ManyToMany
    @OrderBy("identifiant asc")
    @JoinTable(name = "dossier_condition_particuliere_batiments",
        uniqueConstraints = @UniqueConstraint(columnNames = {"dossier_condition_particuliere_id", "batiment_id"}, name = "dossier_condition_particuliere_batiments_pkey"),
        joinColumns = {@JoinColumn(name = "dossier_condition_particuliere_id")},
        inverseJoinColumns = {@JoinColumn(name = "batiment_id")}
    )
    private List<BatimentEntity> batiments;

    @ManyToMany
    @OrderBy("identifiant asc")
    @JoinTable(name = "dossier_condition_particuliere_installations",
        uniqueConstraints = @UniqueConstraint(columnNames = {"dossier_condition_particuliere_id", "installation_id"}, name = "dossier_condition_particuliere_installations_pkey"),
        joinColumns = {@JoinColumn(name = "dossier_condition_particuliere_id")},
        inverseJoinColumns = {@JoinColumn(name = "installation_id")}
    )
    private List<InstallationEntity> installations;

    @ManyToMany
    @OrderBy("identifiant asc")
    @JoinTable(name = "dossier_condition_particuliere_depot_substances",
        uniqueConstraints = @UniqueConstraint(columnNames = {"dossier_condition_particuliere_id", "depot_substance_id"}, name = "dossier_condition_particuliere_depot_substances_pkey"),
        joinColumns = {@JoinColumn(name = "dossier_condition_particuliere_id")},
        inverseJoinColumns = {@JoinColumn(name = "depot_substance_id")}
    )
    private List<DepotSubstanceEntity> depotSubstances;

    @ManyToMany
    @OrderBy("identifiant asc")
    @JoinTable(name = "dossier_condition_particuliere_depot_dechets",
        uniqueConstraints = @UniqueConstraint(columnNames = {"dossier_condition_particuliere_id", "depot_dechet_id"}, name = "dossier_condition_particuliere_depot_dechets_pkey"),
        joinColumns = {@JoinColumn(name = "dossier_condition_particuliere_id")},
        inverseJoinColumns = {@JoinColumn(name = "depot_dechet_id")}
    )
    private List<DepotDechetEntity> depotDechets;

    @ManyToMany
    @OrderBy("identifiant asc")
    @JoinTable(name = "dossier_condition_particuliere_rejet_eaus",
        uniqueConstraints = @UniqueConstraint(columnNames = {"dossier_condition_particuliere_id", "rejet_eau_id"}, name = "dossier_condition_particuliere_rejet_eaus_pkey"),
        joinColumns = {@JoinColumn(name = "dossier_condition_particuliere_id")},
        inverseJoinColumns = {@JoinColumn(name = "rejet_eau_id")}
    )
    private List<RejetEauEntity> rejetEaus;

    @ManyToMany
    @OrderBy("identifiant asc")
    @JoinTable(name = "dossier_condition_particuliere_deversements",
        uniqueConstraints = @UniqueConstraint(columnNames = {"dossier_condition_particuliere_id", "deversement_id"}, name = "dossier_condition_particuliere_deversements_pkey"),
        joinColumns = {@JoinColumn(name = "dossier_condition_particuliere_id")},
        inverseJoinColumns = {@JoinColumn(name = "deversement_id")}
    )
    private List<DeversementEntity> deversements;

    @ManyToMany
    @OrderBy("identifiant asc")
    @JoinTable(name = "dossier_condition_particuliere_rejet_atmospheriques",
        uniqueConstraints = @UniqueConstraint(columnNames = {"dossier_condition_particuliere_id", "rejet_atmospherique_id"}, name = "dossier_condition_particuliere_rejet_atmospheriques_pkey"),
        joinColumns = {@JoinColumn(name = "dossier_condition_particuliere_id")},
        inverseJoinColumns = {@JoinColumn(name = "rejet_atmospherique_id")}
    )
    private List<RejetAtmospheriqueEntity> rejetAtmospheriques;

    /**
     * The ordre.
     */
    @Column(name = "ordre")
    private Integer ordre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notification")
    private NotificationEntity notification;
}
