package be.nsi.labo.jpa.labojpa.domain.notifications;

import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/***
 * Warning! 'date' and 'avis' of this class must be copied into corresponding rsDecisionEntity instance
 * rsDecisionEntity is found based on 'Notification'.dossier (this entity is embedded into 'Notification')
 *
 * cfr : "Pour une extension RS
 * La décision et la date de décision sont recopiées."
 * (src: https://confluence.nsi-sa.be/pages/viewpage.action?pageId=1006108864 )
 */
@Embeddable
@Getter
@Setter
public class NotificationExtensionRapportSyntheseEntity implements Serializable {

    /**
     * When setting 'avis', we MUST copy it in 'rsDecisionEntity.decision' !!
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ext_rs_avis", columnDefinition = "varchar2(103)", foreignKey = @ForeignKey(name = "notification_fk_ext_rs_avis"))
    //see LovDomCodes.DECISION_PERMIS
    private LovEntity avis;

    /**
     * When setting 'dateDecision', we MUST copy it in 'rsDecisionEntity.dateDecision' !!
     */
    @Column(name = "ext_rs_date_decision")
    private Date dateDecision;

    @Column(name = "ext_rs_date_affichage_decision_debut")
    private Date dateAffichageDecisionDebut;

    @Column(name = "ext_rs_date_affichage_decision_fin")
    private Date dateAffichageDecisionFin;

}
