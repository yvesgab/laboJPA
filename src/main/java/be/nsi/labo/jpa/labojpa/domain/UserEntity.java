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
    name = "sec_user"
)
@Inheritance(
    strategy = InheritanceType.JOINED
)
public class UserEntity extends AbstractSecurityBaseEntity<Long> {
    @Column(
        unique = true,
        nullable = false
    )
    private @NotNull String name;
    @Column(
        nullable = false
    )
    @ColumnDefault("true")
    private boolean enabled = true;
    @Column(
        name = "account_non_expired",
        nullable = false
    )
    @ColumnDefault("true")
    private boolean accountNonExpired = true;
    @Column(
        name = "account_non_locked",
        nullable = false
    )
    @ColumnDefault("true")
    private boolean accountNonLocked = true;
    @ManyToMany(
        fetch = FetchType.LAZY
    )
    @JoinTable(
        name = "sec_user_authority",
        joinColumns = {@JoinColumn(
    name = "user_id",
    nullable = false
)},
        foreignKey = @ForeignKey(
    name = "FK_secuserauthority_secuser"
),
        inverseJoinColumns = {@JoinColumn(
    name = "authority_id",
    nullable = false
)},
        inverseForeignKey = @ForeignKey(
    name = "FK_secuserauthority_secauth"
)
    )
    private Set<AuthorityEntity> authorities = new LinkedHashSet();


    public boolean hasAuthority(AuthorityEntity authority) {
        return this.authorities.contains(authority);
    }

    public void addAuthority(AuthorityEntity authority) {
        this.authorities.add(authority);
    }

    public void removeAuthority(AuthorityEntity authority) {
        this.authorities.remove(authority);
    }

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public boolean isEnabled() {
        return this.enabled;
    }

    @Generated
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Generated
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Generated
    public Set<AuthorityEntity> getAuthorities() {
        return this.authorities;
    }

    @Generated
    public void setName(final String name) {
        this.name = name;
    }

    @Generated
    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    @Generated
    public void setAccountNonExpired(final boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Generated
    public void setAccountNonLocked(final boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Generated
    public void setAuthorities(final Set<AuthorityEntity> authorities) {
        this.authorities = authorities;
    }

    @Generated
    public UserEntity() {
    }

    @Generated
    public String toString() {
        String var10000 = super.toString();
        return "UserEntity(super=" + var10000 + ", name=" + this.getName() + ", enabled=" + this.isEnabled() + ")";
    }
}
