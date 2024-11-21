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
 * A RejetAtmospheriqueEntity.
 */
@Entity
@Table(name = "rejet_atmospherique", uniqueConstraints =
@UniqueConstraint(columnNames = {"identifiant", "dossier"}))
@Getter     // Lombok
@Setter     // Lombok
@NoArgsConstructor      // Lombok
@AllArgsConstructor     // Lombok)
public class RejetAtmospheriqueEntity extends AbstractCaracteristiqueEntity implements AuditingEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "installation")
    private InstallationEntity installation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "depot")
    private DepotSubstanceEntity depot;

    @Column(name = "nom_usuel_description")
    private String nomUsuelDescription;

    @Column(name = "hauteur_debouche", precision = 10, scale = 3)
    private BigDecimal hauteurDebouche;

    @Column(name = "nature_effluents", columnDefinition = "TEXT")
    private String natureEffluents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resultats_analyse")
    private LovEntity resultatsAnalyse;

    @Column(name = "doc_technique")
    private String docTechnique;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "depot_dechet")
    private DepotDechetEntity depotDechet;

    public String getLibelle() {
        return (StringUtils.isNotBlank(nomUsuelDescription) ? nomUsuelDescription : "");
    }

}
