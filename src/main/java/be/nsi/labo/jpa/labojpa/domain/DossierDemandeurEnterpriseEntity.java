package be.nsi.labo.jpa.labojpa.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.*;

/**
 * A DossierDemandeurEnterpriseEntity.
 */
@Entity
@Table(name = "dossier_demandeur_enterprise", uniqueConstraints =
@UniqueConstraint(columnNames = {"enterprise", "dossier", "type_demandeur"}, name = "dossier_demandeur_enterprise_unique_enterprise_dossier_type"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class DossierDemandeurEnterpriseEntity extends DossierDemandeurEntity implements AuditingEntity {

    @ManyToOne
    @JoinColumn(name = "enterprise")
    private EnterpriseEntity enterprise;

}
