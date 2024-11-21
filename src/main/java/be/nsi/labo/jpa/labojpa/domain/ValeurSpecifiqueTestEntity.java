package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A ValeurSpecifiqueTestEntity.
 */
@Entity
@Table(name = "valeur_specifique_test")
@Getter     // Lombok
@Setter     // Lombok
@NoArgsConstructor      // Lombok
@AllArgsConstructor     // Lombok
public class ValeurSpecifiqueTestEntity extends AbstractBaseAuditingEntity implements Serializable, AuditingEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "valeur_specifique")
    private LovEntity valeurSpecifique;

    @JoinColumn(name = "test")
    private String test;
}
