package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.*;

/**
 * A DossierDemandeurPersonEntity.
 */
@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class DossierDemandeurEntity extends AbstractBaseAuditingEntity implements AuditingEntity {

    @ManyToOne
    @JoinColumn(name = "dossier")
    private DossierEntity dossier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "send_mode")
    private LovEntity sendMode;

    @Embedded
    private AdresseEmbeddedEntity address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_demandeur")
    private LovEntity typeDemandeur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "qualification")
    private LovEntity qualification;

    @Column(name = "non_notifie", columnDefinition = "boolean default false")
    private Boolean nonNotifie;

    @Column(name = "consorts", columnDefinition = "boolean default false")
    private Boolean consorts;

    @Column(name = "represente_par", columnDefinition = "boolean default false")
    private Boolean representePar;

}
