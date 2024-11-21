package be.nsi.labo.jpa.labojpa.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

/**
 * A DossierClassementEntity.
 */
@Entity
@Table(name = "dossier_classement", uniqueConstraints =
@UniqueConstraint(columnNames = {"type_classement", "classement", "dossier"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DossierClassementEntity extends AbstractBaseAuditingEntity implements AuditingEntity {

    @Column(name = "type_classement")
    private String typeClassement;

    @ManyToOne
    @JoinColumn(name = "classement")
    private ClassementEntity classement;

    @Column(name = "avertissement")
    private String avertissement;

    @ManyToOne
    @JoinColumn(name = "dossier")
    private DossierEntity dossier;

    @Column(name = "num_classement")
    private String numClassement;

}
