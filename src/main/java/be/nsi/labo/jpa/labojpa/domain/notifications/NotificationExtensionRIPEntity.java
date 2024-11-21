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
public class NotificationExtensionRIPEntity implements Serializable {

    @Column(name = "ext_rip_date_organisation")
    private Date dateOrganisation;

    @Column(name = "ext_rip_lieu_organisation")
    private String lieuOrganisation;


}
