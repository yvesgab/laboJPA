package be.nsi.labo.jpa.labojpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name = "dossier_payload")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DossierPayloadEntity extends AbstractBaseAuditingEntity {

    @ManyToOne
    @JoinColumn(name = "dossier", foreignKey = @ForeignKey(name = "dossier_payload_fk_dossier"))
    private DossierEntity dossier;

    @Column(name = "payload", columnDefinition = "TEXT")
    private String payload;
}
