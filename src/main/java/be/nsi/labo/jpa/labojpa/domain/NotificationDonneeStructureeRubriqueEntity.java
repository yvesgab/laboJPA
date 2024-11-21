package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.notifications.NotificationEntity;
import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import be.nsi.labo.jpa.labojpa.domain.referentiels.RubriqueEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A NotificationDonneeStructureeRubrique.
 */
@Entity
@Table(name = "notification_donnees_structurees_rubrique",
       uniqueConstraints = @UniqueConstraint(columnNames = { "notif_id", "rubrique_id" },
                                             name = "notification_donnees_structurees_rubrique_unique_rubrique"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDonneeStructureeRubriqueEntity extends AbstractBaseEntity {

    @ManyToOne()
    @JoinColumn(name = "notif_id", foreignKey = @ForeignKey(name = "notification_ds_rubrique_fk_notif_id"))
    private NotificationEntity notification;

    @ManyToOne
    @JoinColumn(name = "rubrique_id", foreignKey = @ForeignKey(name = "notification_ds_rubrique_fk_rubrique_id"))
    private RubriqueEntity rubrique;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statut_envoye", foreignKey = @ForeignKey(name = "notification_ds_rubrique_fk_statut_envoye"))
    private LovEntity statutEnvoye;

    @ManyToOne
    @JoinColumn(name = "statut_notice", foreignKey = @ForeignKey(name = "notification_ds_rubrique_fk_statut_notice"))
    private LovEntity statutNotice;

    @Column(name = "reponse_sur")
    private Boolean reponseSur;

    @Column(name = "traitement")
    private String traitement;
}
