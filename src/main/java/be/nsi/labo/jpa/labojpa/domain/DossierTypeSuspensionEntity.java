package be.nsi.labo.jpa.labojpa.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DossierTypeSuspensionEntity.
 */
@Entity
@Table(name = "dossier_type_suspension",
       uniqueConstraints = @UniqueConstraint(columnNames = {"dossier_type", "code"}, name = "dossier_type_suspension_unique_dossier_type_code"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DossierTypeSuspensionEntity extends AbstractBaseAuditingEntity implements Serializable {

    @Column(name = "code")
    private String code;

    @Column(name = "libelle_fr")
    private String libelleFr;

    @Column(name = "libelle_de")
    private String libelleDe;

    @Column(name = "fin_obligatoire")
    private Boolean finObligatoire;

    @ManyToOne
    @JoinColumn(name = "dossier_type")
    private DossierTypeEntity dossierType;
}
