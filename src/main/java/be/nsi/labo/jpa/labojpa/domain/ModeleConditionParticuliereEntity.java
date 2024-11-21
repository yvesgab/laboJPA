package be.nsi.labo.jpa.labojpa.domain;

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
import java.util.List;
import java.util.Objects;

/**
 * A ModeleConditionParticuliereEntity.
 */
@Entity
@Table(name = "modele_condition_particuliere")
@Getter     // Lombok
@Setter     // Lombok
@NoArgsConstructor      // Lombok
@AllArgsConstructor     // Lombok)
public class ModeleConditionParticuliereEntity extends AbstractAuditingEntity implements Serializable, AuditingEntity {

    @Id
    @NotNull
    @Size(max = 255)
    @Comment(value = "The code")
    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "libelle_fr", nullable = false)
    private String libelleFr;

    @Column(name = "libelle_de")
    private String libelleDe;

    @Column(name = "modele_fr", nullable = false, columnDefinition = "TEXT")
    private String modeleFr;

    @Column(name = "modele_de", columnDefinition = "TEXT")
    private String modeleDe;

    @ManyToMany
    @OrderBy("id asc")
    @JoinTable(name = "modele_condition_particuliere_rubriques",
        uniqueConstraints = @UniqueConstraint(columnNames = {"modele_condition_particuliere_code", "rubrique_id"}, name = "modele_condition_particuliere_rubrique_pkey"),
        joinColumns = {@JoinColumn(name = "modele_condition_particuliere_code")},
        inverseJoinColumns = {@JoinColumn(name = "rubrique_id")}
    )
    private List<RubriqueEntity> rubriques;

    @ManyToMany
    @OrderBy("code asc")
    @JoinTable(name = "modele_condition_particuliere_classements",
        uniqueConstraints = @UniqueConstraint(columnNames = {"modele_condition_particuliere_code", "classement_code"}, name = "modele_condition_particuliere_classement_pkey"),
        joinColumns = {@JoinColumn(name = "modele_condition_particuliere_code")},
        inverseJoinColumns = {@JoinColumn(name = "classement_code")}
    )
    private List<ClassementEntity> classements;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id asc")
    @JoinColumn(name = "modele_condition_particuliere")
    private List<ValeurSpecifiqueTestEntity> valeurSpecifiqueTests;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModeleConditionParticuliereEntity that = (ModeleConditionParticuliereEntity) o;
        return Objects.equals(code, that.code) &&
            Objects.equals(libelleFr, that.libelleFr) &&
            Objects.equals(libelleDe, that.libelleDe) &&
            Objects.equals(modeleFr, that.modeleFr) &&
            Objects.equals(modeleDe, that.modeleDe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, libelleFr, libelleDe, modeleFr, modeleDe);
    }
}
