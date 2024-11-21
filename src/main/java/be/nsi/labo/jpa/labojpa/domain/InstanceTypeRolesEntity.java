package be.nsi.labo.jpa.labojpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "instance_type_profiles")
@Getter     // Lombok
@Setter     // Lombok
@NoArgsConstructor      // Lombok
@AllArgsConstructor     // Lombok
public class InstanceTypeRolesEntity extends AbstractBaseEntity implements Serializable {

    @Column(name = "default_profile", nullable = false)
    private boolean defaultRole;

    @ManyToOne()
    @JoinColumn(name = "profile_id", nullable = false)
    private RoleEntity role;

    @ManyToOne()
    @JoinColumn(name = "instance_type_code", nullable = false)
    private InstanceTypeEntity instanceType;
}
