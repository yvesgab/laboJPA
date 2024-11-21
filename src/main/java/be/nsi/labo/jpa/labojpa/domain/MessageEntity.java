package be.nsi.labo.jpa.labojpa.domain;


import be.nsi.labo.jpa.labojpa.domain.notifications.NotificationEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A Message.
 */
@Entity
@Table(name = "message")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageEntity extends AbstractBaseAuditingEntity implements Serializable, AuditingEntity {

    @Column(name = "date")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "type")
    private EvenementEntity type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notification")
    private NotificationEntity notification;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dossier")
    private DossierEntity dossier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_twice")
    private UserTwiceEntity user;

    @Column(name = "message_erreur", columnDefinition = "TEXT")
    private String messageErreur;

    @Column(name = "traite", nullable = false)
    private boolean traite;

    @Column(name = "critique", nullable = false)
    private boolean critique;

}
