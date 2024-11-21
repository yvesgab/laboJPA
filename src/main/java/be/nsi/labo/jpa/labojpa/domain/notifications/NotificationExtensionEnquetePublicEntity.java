package be.nsi.labo.jpa.labojpa.domain.notifications;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Embeddable
@Getter
@Setter
public class NotificationExtensionEnquetePublicEntity implements Serializable {

    @Column(name = "informations", columnDefinition = "TEXT")
    private String informations;

    @Column(name = "date_affichage_debut")
    private Date dateAffichageDebut;

    @Column(name = "date_affichage_fin")
    private Date dateAffichageFin;

    @Column(name = "date_ep_debut")
    private Date dateEpDebut;

    @Column(name = "date_ep_fin")
    private Date dateEpFin;

    @Column(name = "pv_ep", columnDefinition = "TEXT")
    private String pvEp;

    @Column(name = "pv_ep_edited", columnDefinition = "TEXT")
    private String pvEpEdited;

    @Column(name = "reclamations", columnDefinition = "TEXT")
    private String reclamations;

    @Column(name = "reclamations_edited", columnDefinition = "TEXT")
    private String reclamationsEdited;

    @Column(name = "avis_college", columnDefinition = "TEXT")
    private String avisCollege;

    @Column(name = "avis_college_edited", columnDefinition = "TEXT")
    private String avisCollegeEdited;
}
