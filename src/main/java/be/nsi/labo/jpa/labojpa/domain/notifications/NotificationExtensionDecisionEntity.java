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
public class NotificationExtensionDecisionEntity implements Serializable {

    @Column(name = "ext_dec_date_affichage_decision_debut")
    private Date dateAffichageDecisionDebut;

    @Column(name = "ext_dec_date_affichage_decision_fin")
    private Date dateAffichageDecisionFin;


}
