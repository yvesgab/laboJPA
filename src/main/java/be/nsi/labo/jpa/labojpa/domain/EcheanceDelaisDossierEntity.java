package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "echeance_delais_dossier")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EcheanceDelaisDossierEntity extends AbstractBaseAuditingEntity implements Serializable {

    @JoinColumn(
        name = "dossier_id",
        table = "dossier",
        referencedColumnName = "id",
        nullable = false,
        foreignKey = @ForeignKey(name = "echeance_delais_dossier_fk_dossier")
    )
    private Long dossierId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "extension", columnDefinition = "varchar2(103)", foreignKey = @ForeignKey(name = "echeance_delais_dossier_fk_extension"))
    private LovEntity extension;

    @Column(name = "code_delai")
    private String codeDelai;

    @Column(name = "delai")
    private Long delai;

    @Column(name = "date_debut")
    private Date dateDebut;

    @Column(name = "date_fin")
    private Date dateFin;

    @Column(name = "delai_notification")
    private String delaiNotification;

    @Column(name = "ordre")
    private Long ordre;

    @Column(name = "etape")
    private String etape;
}
