package be.nsi.labo.jpa.labojpa.domain.notifications;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A ReponseNotificationEntity.
 */
@Embeddable
@Getter
@Setter
public class ReponseNotificationEntity implements Serializable {

    @Column(name = "reponse_date_echance")
    private LocalDate dateEchance;

    @Column(name = "reponse_date_envoi")
    private LocalDate dateEnvoi;

    @Column(name = "reponse_date_reception_commune")
    private LocalDate dateReceptionCommune;

    @Column(name = "reponse_date_reception_dpa")
    private LocalDate dateReceptionDPA;

    @Column(name = "reponse_hors_delai")
    private Boolean reponseHorsDelai;

    @Column(name = "reponse_contenu", columnDefinition="TEXT")
    private String reponseContenu;

    @Column(name = "reponse_contenu_editee", columnDefinition="TEXT")
    private String reponseContenuEditee;

    @Column(name = "reponse_id_electronique")
    private String idElectronique;

    @Column(name = "reponse_status")
    private String responseStatus;

    @Column(name = "organisation_date")
    private LocalDate organisationDate;

    @Column(name = "organisation_lieu")
    private String organisationLieu;
}
