package be.nsi.labo.jpa.labojpa.domain.notifications;

import be.nsi.labo.jpa.labojpa.domain.AbstractBaseAuditingEntity;
import be.nsi.labo.jpa.labojpa.domain.documents.DocumentEntity;
import be.nsi.labo.jpa.labojpa.domain.enums.NotificationDocumentLien;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * NotificationDocument Entity.
 */
@Entity
@Table(name = "notification_document", uniqueConstraints = @UniqueConstraint(columnNames = {"id_notification", "id_document"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDocumentEntity extends AbstractBaseAuditingEntity implements Serializable {

    @Column(name = "id_notification")
    private Long notificationId;

    @ManyToOne
    @JoinColumn(name = "id_document")
    private DocumentEntity document;

    @Column(name = "type_lien")
    @Enumerated(EnumType.STRING)
    private NotificationDocumentLien typeLien;
}
