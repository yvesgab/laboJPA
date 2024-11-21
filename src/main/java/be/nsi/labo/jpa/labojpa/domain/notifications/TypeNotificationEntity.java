package be.nsi.labo.jpa.labojpa.domain.notifications;

import be.nsi.labo.jpa.labojpa.domain.DocumentTypeEntity;
import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

/**
 * A TypeNotificationEntity.
 */
@Entity
@Table(name = "type_notification")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypeNotificationEntity extends AbstractTypeNotificationEntity implements Serializable {

    @Id
    @Column(name = "code", unique = true, updatable = false, nullable = false)
    private String code;

    @ManyToOne
    @JoinColumn(name = "type_notification_lie")
    private TypeNotificationEntity typeNotificationLie;

    @ManyToMany
    @OrderBy("labelFr asc")
    @JoinTable(name = "type_notification_originaux",
               uniqueConstraints = @UniqueConstraint(columnNames = {"type_notification_id", "document_type_id"}, name = "instance_mode_envoi_pkey"),
               joinColumns = {@JoinColumn(name = "type_notification_id")},
               inverseJoinColumns = {@JoinColumn(name = "document_type_id")}
    )
    private Set<DocumentTypeEntity> originaux;

    @ManyToMany(fetch = FetchType.LAZY)
    @OrderBy("domCode asc")
    @JoinTable(name = "type_notification_mode_envoi",
               uniqueConstraints = @UniqueConstraint(columnNames = {"type_notification_code", "mode_envoi_dom_code"}, name = "type_notification_mode_envoi_pkey"),
               joinColumns = { @JoinColumn(name = "type_notification_code") },
               inverseJoinColumns = { @JoinColumn(name = "mode_envoi_dom_code") }
    )
    private Set<LovEntity> modesEnvoi;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
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
        TypeNotificationEntity other = (TypeNotificationEntity) obj;
        if (other.getCode() == null || getCode() == null) {
            return false;
        } else if (!code.equals(other.getCode())) {
            return false;
        }
        return true;
    }

}
