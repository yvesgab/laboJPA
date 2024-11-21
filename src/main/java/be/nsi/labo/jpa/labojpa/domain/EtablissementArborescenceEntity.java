package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.enums.EtablissementRoute;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A EtablissementArborescenceEntity.
 */
@Entity
@Table(name = "etablissement_arborescence")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EtablissementArborescenceEntity extends AbstractBaseAuditingEntity implements Serializable {

    @Column(name = "_level", nullable = false)
    private Integer level;

    @Column(name = "_label", nullable = false)
    private String label;

    @Column(name = "path")
    @Enumerated(EnumType.STRING)
    private EtablissementRoute path;

    @Column(name = "_order", nullable = false)
    private Integer order;
}
