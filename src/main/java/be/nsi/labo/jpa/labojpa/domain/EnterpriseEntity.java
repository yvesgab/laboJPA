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
 * A EnterpriseEntity.
 */
@Entity
@Table(name = "enterprise")
@Getter     // Lombok
@Setter     // Lombok
@NoArgsConstructor      // Lombok
@AllArgsConstructor     // Lombok
public class EnterpriseEntity extends AbstractBaseAuditingEntity implements Serializable, AuditingEntity {

    @Column(name = "enterprise_number", unique = true)
    private String enterpriseNumber;

    @Column(name = "social_denomination")
    private String socialDenomination;

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
    @JoinColumn(name = "enterprise_juridical_form")
    private LovEntity enterpriseJuridicalForm;

    @Column(name = "other_legal_form")
    private String autreFormeJuridique;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language")
    private LovEntity language;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country")
    private LovEntity country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enterprise_type")
    private LovEntity enterpriseType;

    @ManyToOne
    @JoinColumn(name = "locality")
    private LocaliteEntity locality;

}
