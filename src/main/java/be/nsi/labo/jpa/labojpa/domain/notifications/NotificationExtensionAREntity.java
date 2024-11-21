package be.nsi.labo.jpa.labojpa.domain.notifications;

import be.nsi.labo.jpa.labojpa.domain.DossierEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Embeddable
@Getter
@Setter
public class NotificationExtensionAREntity implements Serializable {

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "notification_ar_dossier",
        uniqueConstraints = @UniqueConstraint(columnNames = {"notification_id", "dossier_id"}, name = "notification_ar_dossier_pkey"),
        joinColumns = {@JoinColumn(name = "notification_id")},
        inverseJoinColumns = {@JoinColumn(name = "dossier_id")}
    )
    private Set<DossierEntity> dossiers;

}
