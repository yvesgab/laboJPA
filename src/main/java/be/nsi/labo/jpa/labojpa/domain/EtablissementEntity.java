package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import be.nsi.labo.jpa.labojpa.domain.referentiels.LocaliteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A EtablissementEntity.
 */
@Entity
@Table(name = "etablissement")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EtablissementEntity extends AbstractBaseAuditingEntity implements Serializable, AuditingEntity {

    @Column(name = "num_prive_etablissement", unique = true)
    private String numPriveEtablissement;

    @Column(name = "id_dgo3", unique = true)
    private String idDGO3;

    @Column(name = "id_dgo3_central", unique = true)
    private String idDGO3Central;

    @Column(name = "nom")
    private String nom;

    @Column(name = "is_etablissement")
    private Boolean isEtablissement;

    @Column(name = "numero_bce", unique = true)
    private String numeroBCE;

    @Column(name = "coordonnee_lambert_x")
    private Integer coordonneeLambertX;

    @Column(name = "coordonnee_lambert_y")
    private Integer coordonneeLambertY;

    @Column(name = "rue")
    private String rue;

    @Column(name = "numero")
    private String numero;

    @Column(name = "bte")
    private String bte;

    @ManyToOne
    @JoinColumn(name = "localite")
    private LocaliteEntity localite;

    @Column(name = "numero_telephone")
    private String numeroTelephone;

    @Column(name = "numero_fax")
    private String numeroFax;

    @Column(name = "email")
    private String email;

    @Column(name = "contact")
    private String contact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classe")
    private LovEntity classe;

    @ManyToOne
    @JoinColumn(name = "direction_spw_etablissement")
    private InstanceEntity directionSpwEtablissement;

    @ManyToOne
    @JoinColumn(name = "activite_principale")
    private LovEntity activitePrincipale;

    @Column(name = "activite")
    private String activite;

    @ManyToOne
    @JoinColumn(name = "activite_ied")
    private ClassementEntity activiteIED;

}
