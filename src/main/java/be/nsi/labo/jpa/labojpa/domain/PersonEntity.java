package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import be.nsi.labo.jpa.labojpa.domain.referentiels.LocaliteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A PersonEntity.
 */
@Entity
@Table(name = "person")
@Getter     // Lombok
@Setter     // Lombok
@NoArgsConstructor      // Lombok
@AllArgsConstructor     // Lombok
public class PersonEntity extends AbstractBaseAuditingEntity implements Serializable, AuditingEntity {

    @Column(name = "national_number", unique = true)
    private String nationalNumber;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "street")
    private String street;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "postbox")
    private String postbox;

    @Column(name = "cell_phone")
    private String cellPhone;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "locality_other")
    private String localityOther;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "title")
    private LovEntity title;

    @ManyToOne
    @JoinColumn(name = "language")
    private LovEntity language;

    @ManyToOne
    @JoinColumn(name = "country")
    private LovEntity country;

    @ManyToOne
    @JoinColumn(name = "locality")
    private LocaliteEntity locality;
}
