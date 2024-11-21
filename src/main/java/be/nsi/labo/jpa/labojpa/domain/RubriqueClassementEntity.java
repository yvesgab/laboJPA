package be.nsi.labo.jpa.labojpa.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

/**
 * A RubriqueClassementEntity.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "rubrique_classement",
    uniqueConstraints =
    @UniqueConstraint(columnNames = {"classement", "rubrique_id"}))
public class RubriqueClassementEntity extends AbstractBaseEntity implements Serializable {

    @Column(name = "threshold")
    private Double threshold;

    @Column(name = "warning", nullable = false)
    private String warning;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "classement", nullable = false)
    private ClassementEntity classement;
}
