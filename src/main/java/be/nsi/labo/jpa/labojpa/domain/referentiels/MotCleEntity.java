package be.nsi.labo.jpa.labojpa.domain.referentiels;


import be.nsi.labo.jpa.labojpa.domain.AbstractAuditingEntity;
import be.nsi.labo.jpa.labojpa.domain.AuditingEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * A MotCle.
 */

@Table(name = "mot_cle")
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class MotCleEntity extends AbstractAuditingEntity implements Serializable, AuditingEntity {

    @Id
    @Column(name = "code")
    private String code;

    @NotNull
    @Column(name = "libelle_fr")
    private String libelleFr;

    @NotNull
    @Column(name = "libelle_de")
    private String libelleDe;

    @Column(name = "description")
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MotCleEntity that = (MotCleEntity) o;
        return Objects.equals(code, that.code) &&
            Objects.equals(libelleFr, that.libelleFr) &&
            Objects.equals(libelleDe, that.libelleDe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, libelleFr, libelleDe);
    }
}
