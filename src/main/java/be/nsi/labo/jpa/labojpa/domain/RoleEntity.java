//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package be.nsi.labo.jpa.labojpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.Generated;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(
    name = "sec_role"
)
@Inheritance(
    strategy = InheritanceType.JOINED
)
public class RoleEntity extends AbstractSecurityBaseEntity<Long> {
    @Column(
        unique = true,
        nullable = false
    )
    private @NotNull String name;
    @Column
    private String label;
    @Column(
        nullable = false
    )
    @ColumnDefault("false")
    private boolean system = false;
    @ManyToMany(
        fetch = FetchType.LAZY
    )
    @JoinTable(
        name = "sec_role_authority",
        joinColumns = {@JoinColumn(
    name = "role_id",
    nullable = false
)},
        foreignKey = @ForeignKey(
    name = "FK_secroleauth_secrole"
),
        inverseJoinColumns = {@JoinColumn(
    name = "authority_id",
    nullable = false
)},
        inverseForeignKey = @ForeignKey(
    name = "FK_secroleauth_secauth"
)
    )
    private Set<AuthorityEntity> authorities = new LinkedHashSet();

    public RoleEntity() {
    }

    public boolean hasAuthority(AuthorityEntity authority) {
        return this.authorities.contains(authority);
    }

    public void addAuthority(AuthorityEntity authority) {
        this.authorities.add(authority);
    }

    public void removeAuthority(AuthorityEntity authority) {
        this.authorities.remove(authority);
    }

    public void setName(String name) {

    }

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public String getLabel() {
        return this.label;
    }

    @Generated
    public boolean isSystem() {
        return this.system;
    }

    @Generated
    public Set<AuthorityEntity> getAuthorities() {
        return this.authorities;
    }

    @Generated
    public void setLabel(final String label) {
        this.label = label;
    }

    @Generated
    public void setSystem(final boolean system) {
        this.system = system;
    }

    @Generated
    public void setAuthorities(final Set<AuthorityEntity> authorities) {
        this.authorities = authorities;
    }

    @Generated
    public String toString() {
        String var10000 = super.toString();
        return "RoleEntity(super=" + var10000 + ", name=" + this.getName() + ")";
    }
}
