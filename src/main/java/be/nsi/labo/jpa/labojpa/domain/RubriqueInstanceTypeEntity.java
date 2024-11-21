package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A RubriqueInstanceTypeEntity.
 */
@Entity
@Table(name = "rubrique_instance_type")
@Getter     // Lombok
@Setter     // Lombok
@NoArgsConstructor      // Lombok
@AllArgsConstructor     // Lombok
public class RubriqueInstanceTypeEntity extends AbstractBaseAuditingEntity implements Serializable, AuditingEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "obligation")
    private LovEntity obligation;

    @ManyToOne
    @JoinColumn(name = "instance_type_code")
    private InstanceTypeEntity instanceType;
}
