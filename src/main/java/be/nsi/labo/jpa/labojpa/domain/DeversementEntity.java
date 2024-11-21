package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.caracteristiques.AbstractCaracteristiqueEntity;
import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * A DeversementEntity.
 */
@Entity
@Table(name = "deversement", uniqueConstraints =
@UniqueConstraint(columnNames = {"identifiant", "dossier"}))
@Getter     // Lombok
@Setter     // Lombok
@NoArgsConstructor      // Lombok
@AllArgsConstructor     // Lombok
public class DeversementEntity extends AbstractCaracteristiqueEntity implements AuditingEntity {

    @Column(name = "nom_usuel_description")
    private String nomUsuelDescription;

    @Column(name = "systeme_surveillance")
    private String systemeSurveillance;

    @Column(name = "resultat_analyse")
    private String resultatAnalyse;

    @Column(name = "precision")
    private String precision;

    @Column(name = "debit_jour", precision = 10, scale = 3)
    private BigDecimal debitJour;

    @Column(name = "debit_heure", precision = 10, scale = 3)
    private BigDecimal debitHeure;

    @Column(name = "superficie_collectee", precision = 10, scale = 3)
    private BigDecimal superficieCollectee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rejet_eau")
    private RejetEauEntity rejetEau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "batiment")
    private BatimentEntity batiment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "installation")
    private InstallationEntity installation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "depot_substance")
    private DepotSubstanceEntity depotSubstance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "depot_dechet")
    private DepotDechetEntity depotDechet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_eau")
    private LovEntity typeEau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resultat_analyse_oui_non")
    private LovEntity resultatAnalyseOuiNon;

    public String getLibelle() {
        return (StringUtils.isNotBlank(nomUsuelDescription) ? nomUsuelDescription : "");
    }

}
