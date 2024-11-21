package be.nsi.labo.jpa.labojpa.domain.params;

import be.nsi.labo.jpa.labojpa.domain.AbstractAuditingEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Comment;

/**
 * This represents a lov domain
 */
@Comment(value = "This represents a lov domain")
@Entity
@Table(name = "lov_domain")
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class LovDomainEntity extends AbstractAuditingEntity {

    /**
     * The domain
     */
    @Id
    @NotNull
    @Size(max = 50)
    @Comment(value = "The domain")
    @Column(name = "domain", length = 50, nullable = false)
    private String domain;

    /**
     * The french label
     */
    @NotNull
    @Size(max = 250)
    @Comment(value = "The french label")
    @Column(name = "label_fr", length = 250, nullable = false)
    private String labelFr;

    /**
     * The german label
     */
    @NotNull
    @Size(max = 250)
    @Comment(value = "The german label")
    @Column(name = "label_de", length = 250, nullable = false)
    private String labelDe;

    /**
     * The parent domain
     */
    @Comment(value = "The parent domain")
    @ManyToOne
    @JoinColumn(name = "parent_domain")
    private LovDomainEntity parentDomain;

    /**
     * Is the domain editable ?
     */
    @Comment(value = "Is the domain addable ?")
    @Column(name = "is_addable")
    private boolean isAddable;

    /**
     * Is the domain editable ?
     */
    @Comment(value = "Is the domain editable ?")
    @Column(name = "is_editable")
    private boolean isEditable;

    /**
     * Is the domain editable ?
     */
    @Comment(value = "Is the domain deletable ?")
    @Column(name = "is_deletable")
    private boolean isDeletable;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((domain == null) ? 0 : domain.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LovDomainEntity other = (LovDomainEntity) obj;
        if (domain == null) {
            return other.domain == null;
        } else {
            return domain.equals(other.domain);
        }
    }
}
