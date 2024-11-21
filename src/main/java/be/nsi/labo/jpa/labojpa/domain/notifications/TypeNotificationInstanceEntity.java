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
 * A TypeNotificationInstanceEntity.
 */
@Entity
@Table(name = "type_notification_instance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypeNotificationInstanceEntity extends AbstractTypeNotificationEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_generator")
    @SequenceGenerator(name = "hibernate_generator", sequenceName = "hibernate_sequence", initialValue = 100)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @Column(name = "code", updatable = false, nullable = false)
    private String code;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "type_notification_lie")
    private TypeNotificationInstanceEntity typeNotificationLie;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "type_notification_instance_originaux",
               uniqueConstraints = @UniqueConstraint(columnNames = {"type_notification_instance_id", "document_type_id"}, name = "instance_document_type_pk"),
               joinColumns = {@JoinColumn(name = "type_notification_instance_id")},
               inverseJoinColumns = {@JoinColumn(name = "document_type_id")}
    )
    private Set<DocumentTypeEntity> originaux;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "type_notification_instance_mode_envoi",
               uniqueConstraints = @UniqueConstraint(columnNames = {"type_notification_instance_id", "mode_envoi_dom_code"}, name = "type_notification_instance_mode_envoi_pk"),
               joinColumns = { @JoinColumn(name = "type_notification_instance_id") },
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
        TypeNotificationInstanceEntity other = (TypeNotificationInstanceEntity) obj;
        if (other.getCode() == null || getCode() == null) {
            return false;
        } else if (!code.equals(other.getCode())) {
            return false;
        }
        return true;
    }

}
