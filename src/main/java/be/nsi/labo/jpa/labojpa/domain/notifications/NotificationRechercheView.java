package be.nsi.labo.jpa.labojpa.domain.notifications;

import be.nsi.labo.jpa.labojpa.domain.AbstractBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Immutable;

import java.util.Date;

@Entity
@Table(name = "notification_recherche_view")
@Immutable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRechercheView extends AbstractBaseEntity {

    @Column(name = "dossier")
    private String dossier;

    @Column(name = "dossier_direction_id")
    private Long dossierDirectionId;

    @Column(name = "dossier_type")
    private String dossierType;

    @Column(name = "dossier_type_id")
    private String dossierTypeId;

    @Column(name = "notification")
    private String notification;

    @Column(name = "notification_de")
    private String notificationDe;

    @Column(name = "ar")
    private Boolean ar;

    @Column(name = "type_notification_date_envoi")
    private Boolean typeNotificationDateEnvoi;

    @Column(name = "date_envoi")
    private Date dateEnvoi;

    @Column(name = "date_ar")
    private Date dateAr;

    @Column(name = "direction")
    private String direction;

    @Column(name = "direction_de")
    private String directionDe;

    @Column(name = "direction_id")
    private Long directionId;

    @Column(name = "statut")
    private String statut;

    @Column(name = "num_dossier")
    private String numDossier;

    @Column(name = "num_dossier_objet_dpa")
    private String numDossierObjetDpa;

    @Column(name = "etablissement")
    private String etablissement;

    @Column(name = "mode_envoi")
    private String modeEnvoi;

    @Column(name = "mode_suivi")
    private String modeSuivi;

    @Column(name = "date_echeance")
    private Date dateEcheance;

    @Column(name = "is_sign_elec")
    private Boolean isElec;

    @Column(name = "req_sign_ct")
    private Boolean reqSignCt;

    @Column(name = "sign_ct")
    private Date signCt;

    @Column(name = "req_sign_dir")
    private Boolean reqSignDir;

    @Column(name = "sign_dir")
    private Date signDir;

    @Column(name = "req_sign_ft")
    private Boolean reqSignFt;

    @Column(name = "sign_ft")
    private Date signFt;

    @Column(name = "req_sign_fd")
    private Boolean reqSignFd;

    @Column(name = "sign_fd")
    private Date signFd;

}
