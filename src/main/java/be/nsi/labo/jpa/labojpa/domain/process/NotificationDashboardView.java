package be.nsi.labo.jpa.labojpa.domain.process;

import be.nsi.labo.jpa.labojpa.domain.AbstractBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Immutable;

import java.util.Date;

@Getter
@Setter
@Entity
@Immutable
@Table(name = "notification_dashboard_view")
public class NotificationDashboardView extends AbstractBaseEntity {

    @Column(name = "creation")
    private Date creation;

    @Column(name = "task")
    private String task;

    @Column(name = "notification_id")
    private Long notificationId;

    @Column(name = "notification_contexte")
    private String notificationContexte;

    @Column(name = "notification")
    private String notification;

    @Column(name = "dossier_id")
    private Long dossierId;

    @Column(name = "dossier_num")
    private String dossierNum;

    @Column(name = "dossier_dpa")
    private String dossierDpa;

    @Column(name = "type_dossier")
    private String typeDossier;
}
