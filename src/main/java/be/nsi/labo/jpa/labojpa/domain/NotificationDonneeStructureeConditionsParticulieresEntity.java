package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.notifications.NotificationEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "notification_donnees_structurees_conditions_particulieres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDonneeStructureeConditionsParticulieresEntity extends AbstractBaseEntity {

    @ManyToOne()
    @JoinColumn(name = "notif_id", foreignKey = @ForeignKey(name = "notification_ds_cp_fk_notif_id"))
    private NotificationEntity notification;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "dossier_condition_particuliere_id", foreignKey = @ForeignKey(name = "notification_ds_cp_fk_dossier_condition_particuliere_id"))
    private DossierConditionParticuliereEntity dossierConditionParticuliere;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "notification_donnees_structurees_bloc_id", foreignKey = @ForeignKey(name = "notification_ds_cp_fk_dossier_bloc_id"))
    private NotificationDonneeStructureeBlocEntity notificationDonneesStructureeBloc;

    @Column(name = "code")
    private String code;

    @Column(name = "libelle_fr")
    private String libelleFr;
    @Column(name = "libelle_de")
    private String libelleDe;

    @Column(name = "texte_fr")
    private String texteFr;
    @Column(name = "texte_de")
    private String texteDe;

    @Column(name = "ordre")
    private Long ordre;

    @Column(name = "modele")
    private Boolean modele;

    @Column(name = "traitement")
    private String traitement;

    @Transient
    public Boolean dossier() {
        return dossierConditionParticuliere != null;
    }
}
