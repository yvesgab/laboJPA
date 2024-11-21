package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.notifications.NotificationEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "notification_donnees_structurees_bloc")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDonneeStructureeBlocEntity extends AbstractBaseEntity {

    @ManyToOne()
    @JoinColumn(name = "notif_id", foreignKey = @ForeignKey(name = "notification_ds_bloc_fk_notif_id"))
    private NotificationEntity notification;

    @ManyToOne
    @JoinColumn(name = "dossier_bloc_id", foreignKey = @ForeignKey(name = "notification_ds_bloc_fk_dossier_bloc_id"))
    private DossierBlocEntity dossierBloc;

    @Column(name = "code")
    private String code;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "paragraphe")
    private String paragraphe;

    @Column(name = "ordre")
    private Long ordre;

    @Column(name = "traitement")
    private String traitement;

    @Column(name = "characteristics")
    private String characteristics; // String concat by ';'

    @Transient
    public Boolean dossier() { return dossierBloc != null; }
}
