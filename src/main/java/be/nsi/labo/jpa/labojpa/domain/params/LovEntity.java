package be.nsi.labo.jpa.labojpa.domain.params;

import be.nsi.labo.jpa.labojpa.domain.AbstractAuditingEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.util.Date;

/**
 * This represents a lov
 */

@Entity
@Table(name = "lov")
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class LovEntity extends AbstractAuditingEntity {

    /**
     * The domain & code
     */
    @Id
    @NotNull
    @Size(max = 103)
    @Comment(value = "The domain & code")
    @Column(name = "dom_code", length = 103, nullable = false)
    private String domCode;

    /**
     * The code
     */
    @NotNull
    @Size(max = 50)
    @Comment(value = "The code")
    @Column(name = "code", length = 50, nullable = false)
    private String code;

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
     * The num order
     */
    @NotNull
    @Comment(value = "The num order")
    @Column(name = "num_order", nullable = false)
    private Integer numOrder;

    /**
     * The parent lov
     */
    @Comment(value = "The parent lov")
    @ManyToOne
    @JoinColumn(name = "domain")
    private LovDomainEntity domain;

    /**
     * The parent lov
     */
    @Comment(value = "The parent lov")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_lov")
    private LovEntity parentLov;

    @JoinColumn(name = "statut")
    private boolean statut;

    @JoinColumn(name = "debut_validite")
    private Date debutValidite;

    @JoinColumn(name = "fin_validite")
    private Date finValidite;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((domCode == null) ? 0 : domCode.hashCode());
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
        LovEntity other = (LovEntity) obj;
        if (domCode == null) {
            if (other.domCode != null) {
                return false;
            }
        } else if (!domCode.equals(other.domCode)) {
            return false;
        }
        return true;
    }
}
