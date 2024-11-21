package be.nsi.labo.jpa.labojpa.domain.notifications;

import be.nsi.labo.jpa.labojpa.domain.AbstractBaseEntity;
import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A NotificationSuiviEnvoiEntity.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notification_suivi_envoi")
public class NotificationSuiviEnvoiEntity extends AbstractBaseEntity implements Serializable {

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "mode_envoi")
    private LovEntity modeEnvoi;
}
