package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.notifications.NotificationEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * The type Bloc entity.
 */
@Entity
@Table(name = "dossier_bloc", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"dossier", "code"}, name = "dossier_bloc_unique_dossier_code")
})
@Getter     // Lombok
@Setter     // Lombok
@NoArgsConstructor      // Lombok
@AllArgsConstructor     // Lombok
public class DossierBlocEntity extends AbstractBaseAuditingEntity implements Serializable, AuditingEntity {

    /**
     * The Dossier.
     */
    @ManyToOne
    @JoinColumn(name = "dossier", nullable = false)
    private DossierEntity dossier;

    /**
     * The code
     */
    @Column(name = "code")
    private String code;

    /**
     * The libelle fr.
     */
    @Column(name = "libelle_fr")
    private String libelleFr;
    /**
     * The libelle de.
     */
    @Column(name = "libelle_de")
    private String libelleDe;

    /**
     * The ordre.
     */
    @Column(name = "ordre")
    private Integer ordre;

    /**
     * The texte fr.
     */
    @Column(name = "texte_fr")
    private String texteFr;
    /**
     * The texte de.
     */
    @Column(name = "texte_de")
    private String texteDe;

    /**
     * The decision.
     *
     * Décision à false si :
     *    Par défaut (Bloc/CP créé depuis le DPA)
     *    Bloc/CP qui revient d'une notification demande d'avis NOTICe
     *
     * Décision à true si :
     *    Bloc/CP qui revient d'une notification RS/décision NOTICe
     *    Bloc/CP créé depuis le NoDPA
     *    (Si demande CR acceptée) Bloc/CP copié/collé du DPA
     */
    @Column(name = "decision")
    private boolean decision;

    @ManyToMany
    @OrderBy("identifiant asc")
    @JoinTable(name = "dossier_bloc_parcelles",
        uniqueConstraints = @UniqueConstraint(columnNames = {"dossier_bloc_id", "parcelle_id"}, name = "dossier_bloc_parcelles_pkey"),
        joinColumns = {@JoinColumn(name = "dossier_bloc_id")},
        inverseJoinColumns = {@JoinColumn(name = "parcelle_id")}
    )
    private List<ParcelleEntity> parcelles;

    @ManyToMany
    @OrderBy("identifiant asc")
    @JoinTable(name = "dossier_bloc_batiments",
        uniqueConstraints = @UniqueConstraint(columnNames = {"dossier_bloc_id", "batiment_id"}, name = "dossier_bloc_batiments_pkey"),
        joinColumns = {@JoinColumn(name = "dossier_bloc_id")},
        inverseJoinColumns = {@JoinColumn(name = "batiment_id")}
    )
    private List<BatimentEntity> batiments;

    @ManyToMany
    @OrderBy("identifiant asc")
    @JoinTable(name = "dossier_bloc_installations",
        uniqueConstraints = @UniqueConstraint(columnNames = {"dossier_bloc_id", "installation_id"}, name = "dossier_bloc_installations_pkey"),
        joinColumns = {@JoinColumn(name = "dossier_bloc_id")},
        inverseJoinColumns = {@JoinColumn(name = "installation_id")}
    )
    private List<InstallationEntity> installations;

    @ManyToMany
    @OrderBy("identifiant asc")
    @JoinTable(name = "dossier_bloc_depot_substances",
        uniqueConstraints = @UniqueConstraint(columnNames = {"dossier_bloc_id", "depot_substance_id"}, name = "dossier_bloc_depot_substances_pkey"),
        joinColumns = {@JoinColumn(name = "dossier_bloc_id")},
        inverseJoinColumns = {@JoinColumn(name = "depot_substance_id")}
    )
    private List<DepotSubstanceEntity> depotSubstances;

    @ManyToMany
    @OrderBy("identifiant asc")
    @JoinTable(name = "dossier_bloc_depot_dechets",
        uniqueConstraints = @UniqueConstraint(columnNames = {"dossier_bloc_id", "depot_dechet_id"}, name = "dossier_bloc_depot_dechets_pkey"),
        joinColumns = {@JoinColumn(name = "dossier_bloc_id")},
        inverseJoinColumns = {@JoinColumn(name = "depot_dechet_id")}
    )
    private List<DepotDechetEntity> depotDechets;

    @ManyToMany
    @OrderBy("identifiant asc")
    @JoinTable(name = "dossier_bloc_rejet_eaus",
        uniqueConstraints = @UniqueConstraint(columnNames = {"dossier_bloc_id", "rejet_eau_id"}, name = "dossier_bloc_rejet_eaus_pkey"),
        joinColumns = {@JoinColumn(name = "dossier_bloc_id")},
        inverseJoinColumns = {@JoinColumn(name = "rejet_eau_id")}
    )
    private List<RejetEauEntity> rejetEaus;

    @ManyToMany
    @OrderBy("identifiant asc")
    @JoinTable(name = "dossier_bloc_deversements",
        uniqueConstraints = @UniqueConstraint(columnNames = {"dossier_bloc_id", "deversement_id"}, name = "dossier_bloc_deversements_pkey"),
        joinColumns = {@JoinColumn(name = "dossier_bloc_id")},
        inverseJoinColumns = {@JoinColumn(name = "deversement_id")}
    )
    private List<DeversementEntity> deversements;

    @ManyToMany
    @OrderBy("identifiant asc")
    @JoinTable(name = "dossier_bloc_rejet_atmospheriques",
        uniqueConstraints = @UniqueConstraint(columnNames = {"dossier_bloc_id", "rejet_atmospherique_id"}, name = "dossier_bloc_rejet_atmospheriques_pkey"),
        joinColumns = {@JoinColumn(name = "dossier_bloc_id")},
        inverseJoinColumns = {@JoinColumn(name = "rejet_atmospherique_id")}
    )
    private List<RejetAtmospheriqueEntity> rejetAtmospheriques;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notification")
    private NotificationEntity notification;
}
