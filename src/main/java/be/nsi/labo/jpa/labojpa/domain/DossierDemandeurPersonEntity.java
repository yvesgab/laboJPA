package be.nsi.labo.jpa.labojpa.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.*;

/**
 * A DossierDemandeurPersonEntity.
 */
@Entity
@Table(name = "dossier_demandeur_person", uniqueConstraints =
@UniqueConstraint(columnNames = {"person", "dossier", "type_demandeur"}, name = "dossier_demandeur_person_unique_person_dossier_type"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class DossierDemandeurPersonEntity extends DossierDemandeurEntity implements AuditingEntity {

    @ManyToOne
    @JoinColumn(name = "person")
    private PersonEntity person;
}
