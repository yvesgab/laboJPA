package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.echeanciers.EcheancierEtapeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "dossier_echeances")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DossierEcheanceEntity extends AbstractBaseAuditingEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "dossier", nullable = false)
    private DossierEntity dossier;

    @ManyToOne
    @JoinColumn(name = "etape", nullable = false)
    private EcheancierEtapeEntity echeancierEtape;

    @Column(name = "en_cours")
    private Boolean enCours;

    @Column(name = "debut")
    private Date debut;

    @Column(name = "echeance")
    private Date echeance;

    @Column(name = "fin_effective")
    private Date finEffective;

    @Column(name = "remarque")
    private String remarque;

    @Column(name = "echeance_depassee")
    private Boolean echeanceDepassee;

    @Column(name = "fin_superieure_echeance")
    private Boolean finSupEcheance;

    @Column(name = "visible")
    private Boolean visible;

    @Column(name = "delai")
    private Long delai;

    @Column(name = "echeance_dgo4")
    private Date echeanceDgo4;
}
