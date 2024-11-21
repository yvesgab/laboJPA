package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import be.nsi.labo.jpa.labojpa.domain.referentiels.LocaliteEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class AdresseEmbeddedEntity implements Serializable {

    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "address_street")
    private String addressStreet;

    @Column(name = "address_street_house_number")
    private String addressHouseNumber;

    @Column(name = "address_street_postbox")
    private String addressPostbox;

    @ManyToOne
    @JoinColumn(name = "address_locality")
    private LocaliteEntity addressLocality;

    @Column(name = "address_locality_other")
    private String addressLocalityOther;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_country")
    private LovEntity addressCountry;

}
