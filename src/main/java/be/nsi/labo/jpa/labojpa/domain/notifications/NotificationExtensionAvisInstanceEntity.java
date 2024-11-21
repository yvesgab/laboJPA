package be.nsi.labo.jpa.labojpa.domain.notifications;

import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class NotificationExtensionAvisInstanceEntity implements Serializable {

    @Column(name = "obligatoire")
    private Boolean obligatoire;

    @Column(name = "rubriques")
    private String rubriques;

    @Column(name = "classements")
    private String classements;

    @Column(name = "objets_cartographiques")
    private String objetsCartographiques;

    @Column(name = "motivation", columnDefinition = "TEXT")
    private String motivation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "avis_instance_avis", columnDefinition = "varchar2(103)")
    private LovEntity avis;
}
