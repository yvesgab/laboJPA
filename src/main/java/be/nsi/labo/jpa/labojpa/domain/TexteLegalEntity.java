package be.nsi.labo.jpa.labojpa.domain;


import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import be.nsi.labo.jpa.labojpa.domain.referentiels.RubriqueEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * A TexteLegalEntity.
 */
@Entity
@Table(name = "texte_legal")
@Getter     // Lombok
@Setter     // Lombok
@NoArgsConstructor      // Lombok
@AllArgsConstructor     // Lombok
public class TexteLegalEntity extends AbstractAuditingEntity implements Serializable, AuditingEntity {

    @Id
    @NotNull
    @Size(max = 255)
    @Comment(value = "The code")
    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "reference_texte_fr", columnDefinition = "TEXT")
    private String referenceTexteFr;

    @Column(name = "reference_texte_de", columnDefinition = "TEXT")
    private String referenceTexteDe;

    @Column(name = "url")
    private String url;

    @Column(name = "sequence")
    private Integer sequence;

    @Column(name = "date_debut")
    private Date dateDebut;

    @Column(name = "date_fin")
    private Date dateFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type")
    private LovEntity type;

    @ManyToMany
    @OrderBy("id asc")
    @JoinTable(name = "texte_legal_rubriques",
        uniqueConstraints = @UniqueConstraint(columnNames = {"texte_legal_code", "rubrique_id"}, name = "texte_legal_rubrique_pkey"),
        joinColumns = {@JoinColumn(name = "texte_legal_code")},
        inverseJoinColumns = {@JoinColumn(name = "rubrique_id")}
    )
    private List<RubriqueEntity> rubriques;

    @ManyToMany
    @OrderBy("code asc")
    @JoinTable(name = "texte_legal_classements",
        uniqueConstraints = @UniqueConstraint(columnNames = {"texte_legal_code", "classement_code"}, name = "texte_legal_classement_pkey"),
        joinColumns = {@JoinColumn(name = "texte_legal_code")},
        inverseJoinColumns = {@JoinColumn(name = "classement_code")}
    )
    private List<ClassementEntity> classements;

    @ManyToMany
    @JoinTable(name = "texte_legal_modele_condition_particuliere",
        uniqueConstraints = @UniqueConstraint(columnNames = {"texte_legal_code", "modele_condition_particuliere_code"}, name = "texte_legal_modele_condition_particuliere_pkey"),
        joinColumns = {@JoinColumn(name = "texte_legal_code")},
        inverseJoinColumns = {@JoinColumn(name = "modele_condition_particuliere_code")}
    )
    private List<ModeleConditionParticuliereEntity> modeleConditionParticulieres;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id asc")
    @JoinColumn(name = "texte_legal")
    private List<ValeurSpecifiqueTestEntity> valeurSpecifiqueTests;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TexteLegalEntity that = (TexteLegalEntity) o;
        return Objects.equals(code, that.code) &&
            Objects.equals(referenceTexteFr, that.referenceTexteFr) &&
            Objects.equals(referenceTexteDe, that.referenceTexteDe) &&
            Objects.equals(url, that.url) &&
            Objects.equals(sequence, that.sequence) &&
            Objects.equals(dateDebut, that.dateDebut) &&
            Objects.equals(dateFin, that.dateFin) &&
            Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, referenceTexteFr, referenceTexteDe, url, sequence, dateDebut, dateFin, type);
    }
}
