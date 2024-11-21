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
 * A DepotSubstanceEntity.
 */
@Entity
@Table(name = "depot_substance", uniqueConstraints =
@UniqueConstraint(columnNames = {"identifiant", "dossier"}))
@Getter     // Lombok
@Setter     // Lombok
@NoArgsConstructor      // Lombok
@AllArgsConstructor     // Lombok
public class DepotSubstanceEntity extends AbstractCaracteristiqueEntity implements AuditingEntity {

    @Column(name = "denomination", columnDefinition = "TEXT")
    private String denomination;

    @Column(name = "quantite_maximale", precision = 10, scale = 3)
    private BigDecimal quantiteMaximale;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unite")
    private LovEntity unite;

    @Column(name = "frequence_rotation", precision = 10, scale = 3)
    private BigDecimal frequenceRotation;

    @ManyToOne
    @JoinColumn(name = "unite_frequence_rotation")
    private LovEntity uniteFrequenceRotation;

    @Column(name = "dangereux")
    private Boolean dangereux;

    @Column(name = "numero_cas", length = 50)
    private String numeroCAS;

    @Column(name = "mode_stockage")
    private String modeStockage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "batiment")
    private BatimentEntity batiment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parcelle")
    private ParcelleEntity parcelle;

    public String getLibelle() {
        return (StringUtils.isNotBlank(denomination) ? denomination : "");
    }

}
