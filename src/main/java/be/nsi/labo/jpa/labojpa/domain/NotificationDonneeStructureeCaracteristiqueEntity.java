package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.notifications.NotificationEntity;
import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A NotificationDonneeStructureeCaracteristique.
 */
@Entity
@Table(name = "notification_donnees_structurees_caracteristique",
       uniqueConstraints = @UniqueConstraint(columnNames = {"notif_id", "identifiant"},
                                             name = "notification_donnees_structurees_caracteristique_unique_identifiant"))
@Getter     // Lombok
@Setter     // Lombok
@NoArgsConstructor      // Lombok
@AllArgsConstructor     // Lombok
public class NotificationDonneeStructureeCaracteristiqueEntity extends AbstractBaseEntity {

    @ManyToOne()
    @JoinColumn(name = "notif_id", foreignKey = @ForeignKey(name = "notification_ds_caracteristique_fk_notif_id"))
    private NotificationEntity notification;

    @Column(name = "identifiant")
    private String identifiant;

    @Column(name = "libelle")
    private String libelle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statut_notice", foreignKey = @ForeignKey(name = "notification_ds_caracteristique_fk_statut_notice"))
    private LovEntity statutNotice;

    @Column(name = "reponse_sur")
    private Boolean reponseSur;

}
