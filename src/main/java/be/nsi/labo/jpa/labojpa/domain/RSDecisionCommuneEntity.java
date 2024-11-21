package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.enums.TypeAjout;
import be.nsi.labo.jpa.labojpa.domain.referentiels.CommuneEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rs_decision_commune", uniqueConstraints =
@UniqueConstraint(columnNames = {"rs_decision", "commune"}))
public class RSDecisionCommuneEntity extends AbstractBaseAuditingEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "rs_decision", nullable = false)
    private RSDecisionEntity rsDecision;

    @ManyToOne
    @JoinColumn(name = "commune", nullable = false)
    private CommuneEntity commune;

    @Column(name = "date_debut")
    private Date dateDebut;

    @Column(name = "date_fin")
    private Date dateFin;

    @Column(name = "type_ajout", nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeAjout typeAjout;

}
