package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.enums.DossierRoute;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DossierArborescenceEntity.
 */
@Entity
@Table(name = "dossier_arborescence")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DossierArborescenceEntity extends AbstractBaseAuditingEntity implements Serializable {

    @Column(name = "_level", nullable = false)
    private Integer level;

    @Column(name = "_label", nullable = false)
    private String label;

    @Column(name = "path")
    @Enumerated(EnumType.STRING)
    private DossierRoute path;

    @Column(name = "_order", nullable = false)
    private Integer order;

    @ManyToOne
    @JoinColumn(name = "dossier_type_name"/*, nullable = false*/)
    private DossierTypeEntity dossierType;

    @Column(name = "can_add_document", columnDefinition = "boolean default true")
    private boolean canAddDoc;
}
