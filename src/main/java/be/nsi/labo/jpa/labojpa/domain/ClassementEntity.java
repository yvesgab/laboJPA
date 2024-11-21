package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * A ClassementEntity.
 */
@Entity
@Table(name = "classement")
@Getter     // Lombok
@Setter     // Lombok
@NoArgsConstructor      // Lombok
@AllArgsConstructor     // Lombok
public class ClassementEntity extends AbstractAuditingEntity implements Serializable, AuditingEntity {

    @Id
    @NotNull
    @Size(max = 255)
    @Column(name = "code", nullable = false)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type")
    private LovEntity type;

    @Column(name = "libelle_fr")
    private String libelleFr;

    @Column(name = "libelle_de")
    private String libelleDe;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "classement")
    private List<ClassementInstanceTypeEntity> classementInstanceTypes;

    @Transient

    public List<ClassementInstanceTypeEntity> getClassementInstanceTypesSorted() {
        if(classementInstanceTypes!= null && classementInstanceTypes.size() > 0)
            classementInstanceTypes.sort(Comparator.comparing(cite -> cite.getInstanceType().getLibelle()));
        return classementInstanceTypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassementEntity that = (ClassementEntity) o;
        return Objects.equals(code, that.code) &&
            Objects.equals(type, that.type) &&
            Objects.equals(libelleFr, that.libelleFr) &&
            Objects.equals(libelleDe, that.libelleDe) &&
            Objects.equals(classementInstanceTypes, that.classementInstanceTypes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, type, libelleFr, libelleDe, classementInstanceTypes);
    }
}
