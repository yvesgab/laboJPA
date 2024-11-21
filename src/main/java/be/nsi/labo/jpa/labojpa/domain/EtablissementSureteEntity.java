package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * A EtablissementSureteEntity.
 */
@Entity
@Table(name = "etablissement_surete")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EtablissementSureteEntity extends AbstractBaseAuditingEntity implements Serializable, AuditingEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type")
    private LovEntity type;

    @Column(name = "montant")
    private Double montant;

    @Column(name = "date_operation")
    private Date dateOperation;

    @Column(name = "commentaire")
    private String commentaire;

    @ManyToOne
    @JoinColumn(name = "etablissement", nullable = false)
    private EtablissementEntity etablissement;
}
