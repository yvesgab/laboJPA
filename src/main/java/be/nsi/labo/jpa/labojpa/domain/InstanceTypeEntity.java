package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * A InstanceTypeEntity.
 */
@Entity
@Table(name = "instance_type")
@Getter     // Lombok
@Setter     // Lombok
@NoArgsConstructor      // Lombok
@AllArgsConstructor     // Lombok
public class InstanceTypeEntity extends AbstractAuditingEntity implements Serializable, AuditingEntity {

    @Id
    @Column(name = "code", updatable = false, nullable = false, unique = true)
    private String code;

    @Column(name = "libelle", nullable = false)
    private String libelle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statut")
    private LovEntity statut;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "instanceType")
    private List<InstanceTypeRolesEntity> instanceTypeProfiles;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        return result;
    }

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
        InstanceTypeEntity other = (InstanceTypeEntity) obj;
        if (other.getCode() == null || getCode() == null) {
            return false;
        } else if (!code.equals(other.code)) {
            return false;
        }
        return true;
    }
}
