package be.nsi.labo.jpa.labojpa.domain.documents;

import be.nsi.labo.jpa.labojpa.domain.AbstractBaseAuditingEntity;
import be.nsi.labo.jpa.labojpa.domain.notifications.NotificationEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = DocumentLinkEntity.DOCUMENT_LINK)
@Getter
@Setter
public class DocumentLinkEntity extends AbstractBaseAuditingEntity implements Serializable {

    public static final String DOCUMENT_LINK = "document_link";

    private static final String FK_DOCUMENT_LINK = "fk_" + DOCUMENT_LINK + "_";

    @ManyToOne
    @JoinColumn(name = "notification_id", foreignKey = @ForeignKey(name = FK_DOCUMENT_LINK + "notification_id"), updatable = false)
    private NotificationEntity notification;

    @ManyToOne
    @JoinColumn(name = "document_id", foreignKey = @ForeignKey(name = FK_DOCUMENT_LINK + "document_id"), nullable = false, updatable = false)
    private DocumentEntity document;

    @Column(name = "token", nullable = false, updatable = false)
    private String token;
}
