package be.nsi.labo.jpa.labojpa.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Comment;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Evenement.
 */
@Entity
@Table(name = "evenement")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvenementEntity extends AbstractAuditingEntity implements Serializable, AuditingEntity {

    @Id
    @NotNull
    @Size(max = 255)
    @Comment(value = "The code")
    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "libelle", nullable = false)
    private String libelle;

    @Column(name = "critique")
    private Boolean critique;

    @Column(name = "fonctionnaire_technique")
    private Boolean fonctionnaireTechnique;

    @Column(name = "contact_administratif_dgo3")
    private Boolean contactAdministratifDGO3;

    @Column(name = "contact_technique_dgo3")
    private Boolean contactTechniqueDGO3;

    @Column(name = "fonctionnaire_delegue")
    private Boolean fonctionnaireDelegue;

    @Column(name = "contact_administratif_dgo4")
    private Boolean contactAdministratifDGO4;

    @Column(name = "contact_technique_dgo4")
    private Boolean contactTechniqueDGO4;

    @Column(name = "administrateur")
    private Boolean administrateur;

    @Column(name = "directeur_dgo3")
    private Boolean directeurDGO3;

    @Column(name = "directeur_dgo4")
    private Boolean directeurDGO4;

    @Column(name = "envoi_twice")
    private Boolean envoiTwice;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EvenementEntity that = (EvenementEntity) o;
        return Objects.equals(code, that.code)
               && Objects.equals(libelle, that.libelle)
               && Objects.equals(critique, that.critique)
               && Objects.equals(fonctionnaireTechnique, that.fonctionnaireTechnique)
               && Objects.equals(contactAdministratifDGO3, that.contactAdministratifDGO3)
               && Objects.equals(contactTechniqueDGO3, that.contactTechniqueDGO3)
               && Objects.equals(fonctionnaireDelegue, that.fonctionnaireDelegue)
               && Objects.equals(contactAdministratifDGO4, that.contactAdministratifDGO4)
               && Objects.equals(contactTechniqueDGO4, that.contactTechniqueDGO4)
               && Objects.equals(administrateur, that.administrateur)
               && Objects.equals(directeurDGO3, that.directeurDGO3)
               && Objects.equals(directeurDGO4, that.directeurDGO4)
               && Objects.equals(envoiTwice, that.envoiTwice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, libelle, critique, fonctionnaireTechnique, contactAdministratifDGO3, contactTechniqueDGO3, fonctionnaireDelegue, contactAdministratifDGO4, contactTechniqueDGO4, administrateur, directeurDGO3, directeurDGO4, envoiTwice);
    }
}
