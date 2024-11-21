package be.nsi.labo.jpa.labojpa.domain.notifications;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * A EnvoiNotificationEntity.
 */
@Embeddable
@Getter
@Setter
public class EnvoiNotificationEntity implements Serializable {

    @Column(name = "envoi_date_echance")
    private LocalDate dateEchance;

    @Column(name = "envoi_date_envoi")
    private LocalDateTime dateEnvoi;

    @Column(name = "envoi_date_accuse_reception")
    private LocalDateTime dateAccuseReception;

    @Column(name = "envoi_hors_delai")
    private Boolean envoiHorsDelai;

    @Column(name = "re_envoyer")
    private Boolean reenvoyer;

    @Column(name = "envoi_date_envoi_electronique")
    private LocalDateTime dateEnvoiElectronique;

    @Column(name = "envoi_date_accuse_reception_electronique")
    private LocalDateTime dateAccuseReceptionElectronique;

    @Column(name = "id_electronique")
    private String idElectronique;

    @Embedded
    private ErreurEnvoiEntity erreurEnvoiElectronique;
}
