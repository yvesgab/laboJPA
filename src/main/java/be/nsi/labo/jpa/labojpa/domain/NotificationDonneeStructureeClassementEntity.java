package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.notifications.NotificationEntity;
import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

/**
 * A NotificationDonneeStructureeClassement.
 */
@Entity
@Table(name = "notification_donnees_structurees_classement",
       uniqueConstraints = @UniqueConstraint(columnNames = {"notif_id", "classement_id"},
                                             name = "notification_donnees_structurees_classement_unique_classement"))
@Getter     // Lombok
@Setter     // Lombok
@NoArgsConstructor      // Lombok
@AllArgsConstructor     // Lombok
public class NotificationDonneeStructureeClassementEntity extends AbstractBaseEntity {

    @ManyToOne
    @JoinColumn(name = "notif_id", foreignKey = @ForeignKey(name = "notification_ds_classement_fk_notif_id"))
    private NotificationEntity notification;

    @ManyToOne
    @JoinColumn(name = "classement_id", foreignKey = @ForeignKey(name = "notification_ds_classement_fk_classement_id"))
    private ClassementEntity classement;

    @Column(name = "envoye")
    private Boolean envoye;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statut_notice", foreignKey = @ForeignKey(name = "notification_ds_classement_fk_statut_notice"))
    private LovEntity statutNotice;

    @Column(name = "reponse_sur")
    private Boolean reponseSur;

    @Column(name = "traitement")
    private String traitement;
}
