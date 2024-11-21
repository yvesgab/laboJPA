package be.nsi.labo.jpa.labojpa.domain.notifications;

import be.nsi.labo.jpa.labojpa.domain.AbstractAuditingEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A ModeleNotificationEntity.
 */
@Entity
@Table(name = "modele_notification")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModeleNotificationEntity extends AbstractAuditingEntity implements Serializable {

    @Id
    @Column(name = "code", unique = true, updatable = false, nullable = false)
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "modele")
    private String modele;

    @Column(name = "invitation_demarche")
    private Boolean invitationDemarche;

    @Column(name = "conserver_balise")
    private Boolean conserverBalise;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ModeleNotificationEntity other = (ModeleNotificationEntity) obj;
        if (other.getCode() == null || getCode() == null) {
            return false;
        } else if (!code.equals(other.getCode())) {
            return false;
        }
        return true;
    }
}
