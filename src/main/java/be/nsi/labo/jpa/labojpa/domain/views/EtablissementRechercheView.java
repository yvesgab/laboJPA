package be.nsi.labo.jpa.labojpa.domain.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * A EtablissementRechercheResult.
 */
@Entity
@Table(name = "etablissement_recherche_view")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EtablissementRechercheView implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "id_direction")
    private Long idDirection;

    @Column(name = "nom")
    private String nom;

    @Column(name = "numero_bce")
    private String numeroBCE;

    @Column(name = "id_dgo3")
    private String idDGO3;

    @Column(name = "localite_id")
    private Long localiteId;

    @Column(name = "localite_nom_fr")
    private String localiteNomFr;

    @Column(name = "localite_nom_de")
    private String localiteNomDe;

    @Column(name = "localite_code_postal")
    private String localiteCodePostal;

    @Column(name = "commune_code_ins")
    private String communeIns;

    @Column(name = "commune_nom_fr")
    private String communeNomFr;

    @Column(name = "statut")
    private String statut;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "rue")
    private String rue;

    @Column(name = "numero")
    private String numero;

    @Column(name = "bte")
    private String bte;

    @Column(name = "num_prive_etablissement")
    private String numPriveEtablissement;

    @Column(name = "date_dernier_dossier")
    private Date dateDernierDossier;

    @Column(name = "rubrique")
    private String rubrique;

    @Column(name = "classement")
    private String classement;

    @Column(name = "exploitant")
    private String exploitant;

    @Column(name = "activite_principale")
    private String activitePrincipale;

    @Column(name = "activite_ied")
    private String activiteIED;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        EtablissementRechercheView other = (EtablissementRechercheView) obj;
        if (other.getId() == null || getId() == null) {
            return false;
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
