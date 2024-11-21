package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.notifications.NotificationEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A NotificationDonneeStructuree.
 */
@Entity
@Table(name = "notification_donnees_structurees")
@Getter     // Lombok
@Setter     // Lombok
@NoArgsConstructor      // Lombok
@AllArgsConstructor     // Lombok
public class NotificationDonneeStructureeEntity extends AbstractBaseEntity {

    @OneToOne()
    @JoinColumn(name = "notif_id", foreignKey = @ForeignKey(name = "notification_donnees_structurees_fk_notif_id"), unique = true)
    private NotificationEntity notification;

    @Column(name = "paragraphe_caracteristique", columnDefinition = "TEXT")
    private String paragrapheCaracteristique;
    @Column(name = "paragraphe_rubrique", columnDefinition = "TEXT")
    private String paragrapheRubrique;
    @Column(name = "paragraphe_classement", columnDefinition = "TEXT")
    private String paragrapheClassement;

}
