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
 * A DepotDechetEntity.
 */
@Entity
@Table(name = "depot_dechet", uniqueConstraints = @UniqueConstraint(columnNames = {"identifiant", "dossier"}))
@Getter     // Lombok
@Setter     // Lombok
@NoArgsConstructor      // Lombok
@AllArgsConstructor     // Lombok
public class DepotDechetEntity extends AbstractCaracteristiqueEntity implements AuditingEntity {

    @Column(name = "nom_usuel_description", columnDefinition = "TEXT")
    private String nomUsuelDescription;

    @Column(name = "codes_dechets")
    private String codesDechets;

    @Column(name = "quantite_maximale", precision = 10, scale = 3)
    private BigDecimal quantiteMaximale;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unite_quantite_maximale")
    private LovEntity uniteQuantiteMaximale;

    @Column(name = "flux_annuel", precision = 10, scale = 3)
    private BigDecimal fluxAnnuel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unite_flux_annuel")
    private LovEntity uniteFluxAnnuel;

    @Column(name = "mode_stockage")
    private String modeStockage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "batiment")
    private BatimentEntity batiment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parcelle")
    private ParcelleEntity parcelle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etat_physique")
    private LovEntity etatPhysique;

    public String getLibelle() {
        return (StringUtils.isNotBlank(nomUsuelDescription) ? nomUsuelDescription : "");
    }

}
