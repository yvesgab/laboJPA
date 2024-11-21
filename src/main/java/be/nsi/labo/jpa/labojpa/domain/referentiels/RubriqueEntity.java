package be.nsi.labo.jpa.labojpa.domain.referentiels;


import be.nsi.labo.jpa.labojpa.domain.AbstractBaseAuditingEntity;
import be.nsi.labo.jpa.labojpa.domain.RubriqueClassementEntity;
import be.nsi.labo.jpa.labojpa.domain.RubriqueInstanceTypeEntity;
import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * A Rubrique.
 */
@Getter
@Setter
@Entity
@Table(name = "rubrique")
@NoArgsConstructor
@AllArgsConstructor
public class RubriqueEntity extends AbstractBaseAuditingEntity implements Serializable {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorie", nullable = false)
    private LovEntity categorie;

    @NotNull
    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "date_debut")
    private LocalDate dateDebut;

    @Column(name = "date_fin")
    private LocalDate dateFin;

    @Column(name = "libelle_fr", columnDefinition = "TEXT")
    private String libelleFr;

    @Column(name = "libelle_de", columnDefinition = "TEXT")
    private String libelleDe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classe")
    private LovEntity classe;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "rubrique_id")
    private List<RubriqueClassementEntity> classements;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "rubrique")
    private List<RubriqueInstanceTypeEntity> rubriqueInstanceTypes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_parent")
    private RubriqueEntity idParent;

    @Column(name = "libelle_Simplifie_Fr", columnDefinition = "TEXT")
    private String libelleSimplifieFr;

    @Column(name = "libelle_Simplifie_De", columnDefinition = "TEXT")
    private String libelleSimplifieDe;

    @Column(name = "libelle_Complet_Installation_Fr", columnDefinition = "TEXT")
    private String libelleCompletInstallationFr;

    @Column(name = "libelle_Complet_Installation_De", columnDefinition = "TEXT")
    private String libelleCompletInstallationDe;

    @Column(name = "libelle_Officiel_Installation_Fr", columnDefinition = "TEXT")
    private String libelleOfficielInstallationFr;

    @Column(name = "libelle_Officiel_Installation_De", columnDefinition = "TEXT")
    private String libelleOfficielInstallationDe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "a_sommer")
    private LovEntity sommer;

    @ManyToOne
    @JoinColumn(name = "unite")
    private LovEntity unite;

    @Column(name = "pre_rubrique")
    private Boolean preRubrique;

    @Column(name = "sol")
    private Boolean sol;

    @Column(name = "eie")
    private Boolean eie;

    @ManyToOne
    @JoinColumn(name = "seuil_bas_operator")
    private LovEntity seuilBasOperator;

    @Column(name = "seuil_bas", precision = 12, scale = 3)
    private BigDecimal seuilBas;

    @ManyToOne
    @JoinColumn(name = "seuil_haut_operator")
    private LovEntity seuilHautOperator;

    @Column(name = "seuil_haut", precision = 12, scale = 3)
    private BigDecimal seuilHaut;

    @Column(name = "fd_hz", precision = 12, scale = 3)
    private BigDecimal fdhz;

    @Column(name = "fd_hzr", precision = 12, scale = 3)
    private BigDecimal fdhzr;

    @Column(name = "fd_zi", precision = 12, scale = 3)
    private BigDecimal fdzi;

    @ManyToOne
    @JoinColumn(name = "secteur_activite")
    private LovEntity secteurActivite;

    @ManyToOne
    @JoinColumn(name = "activite_principale")
    private LovEntity activitePrincipale;

    @ManyToOne
    @JoinColumn(name = "type_activite")
    private LovEntity typeActivite;

    @Column(name = "objet")
    private String objet;

    @Column(name = "detail_note", columnDefinition = "TEXT")
    private String detailNote;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "rubriques_annexes",
        uniqueConstraints = @UniqueConstraint(columnNames = {"rubrique_id", "lov_dom_code"}, name = "rubriques_annexes_pkey"),
        joinColumns = {@JoinColumn(name = "rubrique_id")},
        inverseJoinColumns = {@JoinColumn(name = "lov_dom_code")}
    )
    private Set<LovEntity> annexes;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "rubriques_mot_cles",
        uniqueConstraints = @UniqueConstraint(columnNames = {"rubrique_id", "mot_cle_code"}, name = "rubriques_mot_cle_pkey"),
        joinColumns = {@JoinColumn(name = "rubrique_id")},
        inverseJoinColumns = {@JoinColumn(name = "mot_cle_code")}
    )
    private Set<MotCleEntity> motCles;

    @Transient

    public List<RubriqueInstanceTypeEntity> getRubriqueInstanceTypesSorted() {
        if (rubriqueInstanceTypes != null && rubriqueInstanceTypes.size() > 0)
            rubriqueInstanceTypes.sort(Comparator.comparing(rite -> rite.getInstanceType().getLibelle()));
        return rubriqueInstanceTypes;
    }
}
