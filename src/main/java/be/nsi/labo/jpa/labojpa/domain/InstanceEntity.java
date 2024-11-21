package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import be.nsi.labo.jpa.labojpa.domain.referentiels.CommuneEntity;
import be.nsi.labo.jpa.labojpa.domain.referentiels.LocaliteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A InstanceEntity.
 */
@Entity
@Table(name = "instance", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"instance_type_code", "libelle_fr"}, name = "instance_uk_type_code_libelle_fr"),
    @UniqueConstraint(columnNames = {"instance_type_code", "libelle_de"}, name = "instance_uk_type_code_libelle_de"),
})
@Getter     // Lombok
@Setter     // Lombok
@NoArgsConstructor      // Lombok
@AllArgsConstructor     // Lombok
public class InstanceEntity extends AbstractBaseAuditingEntity implements Serializable, AuditingEntity {

    @Column(name = "libelle_courier")
    private String libelleCourier;

    @Column(name = "libelle_fr")
    private String libelleFr;

    @Column(name = "libelle_de")
    private String libelleDe;

    @Column(name = "rue")
    private String rue;

    @Column(name = "numero")
    private String numero;

    @Column(name = "boite")
    private String boite;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "fax")
    private String fax;

    @Column(name = "email")
    private String email;

    @Column(name = "responsable")
    private String responsable;

    @Column(name = "code_carto", unique = true)
    private String codeCarto;

    @Column(name = "code_formulaire", unique = true)
    private String codeFormulaire;

    @Column(name = "code_remise_avis", unique = true)
    private String codeRemiseAvis;

    @ManyToOne
    @JoinColumn(name = "directeur")
    private UserTwiceEntity directeur;

    @ManyToOne
    @JoinColumn(name = "directeur_dgo", foreignKey = @ForeignKey(name = "instance_fk_direction_dgo"))
    private UserTwiceEntity directeurDgo;


    @ManyToMany
    @OrderBy("codeIns asc")
    @JoinTable(name = "instance_commune",
        uniqueConstraints = @UniqueConstraint(columnNames = {"instance_id", "commune_ins"}, name = "instance_commune_pkey"),
        joinColumns = {@JoinColumn(name = "instance_id")},
        inverseJoinColumns = {@JoinColumn(name = "commune_ins")}
    )
    private Set<CommuneEntity> communesDeCompetence;

    @ManyToOne
    @JoinColumn(name = "instance_type_code")
    private InstanceTypeEntity type;

    @ManyToOne
    @JoinColumn(name = "localite")
    private LocaliteEntity localite;

    @Column(name = "localite_autre")
    private String localiteAutre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pays", foreignKey = @ForeignKey(name = "instance_fk_pays"))
    private LovEntity pays;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "langue")
    private LovEntity langue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statut")
    private LovEntity statut;

    @ManyToMany
    @OrderBy("domCode asc")
    @JoinTable(name = "instance_mode_envoi",
        uniqueConstraints = @UniqueConstraint(columnNames = {"instance_id", "mode_envoi_dom_code"}, name = "instance_mode_envoi_pkey"),
        joinColumns = {@JoinColumn(name = "instance_id")},
        inverseJoinColumns = {@JoinColumn(name = "mode_envoi_dom_code")}
    )
    private Set<LovEntity> modesEnvoi = new HashSet<>();
}
