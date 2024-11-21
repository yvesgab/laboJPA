package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A FinAnticipeeEntity.
 */
@Entity
@Table(name = "fin_anticipee")
@Getter     // Lombok
@Setter     // Lombok
@NoArgsConstructor      // Lombok
@AllArgsConstructor     // Lombok
public class FinAnticipeeEntity extends AbstractBaseAuditingEntity implements Serializable {

    @OneToOne(optional = false)
    @JoinColumn(name = "dossier", foreignKey = @ForeignKey(name = "fin_anticipee_fk_dossier_id"))
    private DossierEntity dossier;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "motif", foreignKey = @ForeignKey(name = "fin_anticipee_fk_lov_motif"))
    private LovEntity motif;

    @Column(name = "commentaire", columnDefinition = "TEXT")
    private String commentaire;

}
