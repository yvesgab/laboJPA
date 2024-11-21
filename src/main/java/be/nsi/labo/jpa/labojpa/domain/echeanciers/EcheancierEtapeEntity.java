package be.nsi.labo.jpa.labojpa.domain.echeanciers;

import be.nsi.labo.jpa.labojpa.domain.AbstractBaseAuditingEntity;
import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "echeancier_etape",
       uniqueConstraints = @UniqueConstraint(columnNames = {"echeancier", "code"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EcheancierEtapeEntity extends AbstractBaseAuditingEntity implements Serializable {

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "libelle_fr")
    private String libelleFr;

    @Column(name = "libelle_de")
    private String libelleDe;

    @Column(name = "nep")
    private Boolean nep;

    @Column(name = "ordre")
    private Integer ordre;

    @Column(name = "echeancier")
    private String echeancierCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etape_fin", foreignKey = @ForeignKey(name = "echeancier_etape_fk_etape_fin"))
    private LovEntity etapeFin;
}
