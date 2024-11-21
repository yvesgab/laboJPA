package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A DossierType.
 */
@Entity
@Table(name = "dossier_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DossierTypeEntity extends AbstractAuditingEntity implements Serializable {

    @Id
    @Column(name = "name", unique = true, updatable = false, nullable = false)
    private String name;

    @Column(name = "ordre")
    private Long ordre;

    @Column(name = "libelle_fr")
    private String libelleFr;

    @Column(name = "libelle_de")
    private String libelleDe;

    @Column(name = "description_fr")
    private String descriptionFr;

    @Column(name = "description_de")
    private String descriptionDe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statut", columnDefinition = "varchar2(103) default '#STATUT_ACTIF#INACTIF#'")
    private LovEntity statut;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL/*, orphanRemoval = true*/)
    @JoinColumn(name = "dossier_type_name")
    private List<DossierArborescenceEntity> elements = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "dossier_type_name")
    private List<DocumentTypeEntity> documentTypes = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "dossier_type_name")
    private List<DocumentArborescenceEntity> documentArborescences = new ArrayList<>();

    @Column(name = "prorogation_nombre")
    private Long prorogationNombre;

    @Column(name = "prorogation_duree_maximale")
    private Long prorogationDureeMax;

    @ManyToOne
    @JoinColumn(name = "direction")
    private InstanceEntity direction;

    @Column(name = "requiert_transfert", columnDefinition = "boolean default false")
    private boolean requiertTransfert;

    @Column(name = "id_demarche", unique = true)
    private String idDemarche;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fusionnable", foreignKey = @ForeignKey(name = "dossier_type_fk_fusionnable"))
    private LovEntity fusionnable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commune_obligatoire", foreignKey = @ForeignKey(name = "dossier_type_fk_commune_obligatoire"))
    private LovEntity communeObligatoire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_copie", foreignKey = @ForeignKey(name = "dossier_type_fk_source_copie"))
    private LovEntity sourceCopie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "traitement_recours", foreignKey = @ForeignKey(name = "dossier_type_fk_traitement_recours"))
    private LovEntity traitementRecours;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "suppression_caracteristique", foreignKey = @ForeignKey(name = "dossier_type_fk_suppression_caracteristique"))
    private LovEntity suppressionCaracteristique;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dossier_reference", foreignKey = @ForeignKey(name = "dossier_type_fk_dossier_reference"))
    private LovEntity dossierReference;

    @ManyToMany(fetch = FetchType.LAZY)
    @OrderBy("domCode asc")
    @JoinTable(name = "dossier_type_statuts_parcelles",
        uniqueConstraints = @UniqueConstraint(columnNames = {"dossier_type_id", "statuts_parcelles_dom_code"}, name = "dossier_type_statuts_parcelles_pkey"),
        joinColumns = { @JoinColumn(name = "dossier_type_id" , foreignKey = @ForeignKey(name = "dossier_type_statuts_parcelles_fk_dossier_type") )},
        inverseJoinColumns = { @JoinColumn(name = "statuts_parcelles_dom_code", foreignKey = @ForeignKey(name = "dossier_type_statuts_parcelles_fk_statuts_parcelles") ) }
    )
    private Set<LovEntity> statutsParcelles;

    @ManyToMany(fetch = FetchType.LAZY)
    @OrderBy("domCode asc")
    @JoinTable(name = "dossier_type_statuts_caracteristiques",
        uniqueConstraints = @UniqueConstraint(columnNames = {"dossier_type_id", "statuts_caracteristiques_dom_code"}, name = "dossier_type_statuts_caracteristiques_pkey"),
        joinColumns = { @JoinColumn(name = "dossier_type_id", foreignKey = @ForeignKey(name = "dossier_type_statuts_caracteristiques_fk_dossier_type") ) },
        inverseJoinColumns = { @JoinColumn(name = "statuts_caracteristiques_dom_code", foreignKey = @ForeignKey(name = "dossier_type_statuts_caracteristiques_fk_statuts_caracteristiques") ) }
    )
    private Set<LovEntity> statutsCaracteristiques;


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DossierTypeEntity other = (DossierTypeEntity) obj;
        if (other.getName() == null || getName() == null) {
            return false;
        } else return name.equals(other.name);
    }
}
