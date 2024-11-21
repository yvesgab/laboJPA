//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package be.nsi.labo.jpa.labojpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Generated;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.util.Assert;

@Entity
@Table(
    name = "sec_authority"
)
@Inheritance(
    strategy = InheritanceType.JOINED
)
public class AuthorityEntity extends AbstractSecurityBaseEntity<Long> {
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

    public AuthorityEntity() {
    }

    public void setName(String name) {
        Assert.notNull(name, "error.name.not-provided");
        this.name = name;
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
    public void setLabel(final String label) {
        this.label = label;
    }

    @Generated
    public void setSystem(final boolean system) {
        this.system = system;
    }

    @Generated
    public String toString() {
        String var10000 = super.toString();
        return "AuthorityEntity(super=" + var10000 + ", name=" + this.getName() + ")";
    }
}
