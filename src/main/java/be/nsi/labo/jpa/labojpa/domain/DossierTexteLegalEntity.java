package be.nsi.labo.jpa.labojpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A DossierTexteLegalEntity.
 */
@Entity
@Table(name = "dossier_texte_legal", uniqueConstraints = @UniqueConstraint(columnNames = {"texte_legal", "dossier"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DossierTexteLegalEntity extends AbstractBaseAuditingEntity implements AuditingEntity {

    @ManyToOne
    @JoinColumn(name = "dossier", nullable = false)
    private DossierEntity dossier;

    @ManyToOne
    @JoinColumn(name = "texte_legal", nullable = false)
    private TexteLegalEntity texteLegal;

    @JoinColumn(name = "rubr_cl_val")
    private String rubrClVal;
}
