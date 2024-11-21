package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.caracteristiques.AbstractCaracteristiqueEntity;
import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * A InstallationEntity.
 */
@Entity
@Table(name = "installation", uniqueConstraints =
@UniqueConstraint(columnNames = {"identifiant", "dossier"}))
@Getter     // Lombok
@Setter     // Lombok
@NoArgsConstructor      // Lombok
@AllArgsConstructor     // Lombok)
public class InstallationEntity extends AbstractCaracteristiqueEntity implements AuditingEntity {

    @Column(name = "denomination", columnDefinition = "TEXT")
    private String denomination;

    @Column(name = "capacite_nominale", precision = 10, scale = 3)
    private BigDecimal capaciteNominale;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unite_nominale")
    private LovEntity uniteNominale;

    @Column(name = "capacite_demandee", precision = 10, scale = 3)
    private BigDecimal capaciteDemandee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unite_demandee")
    private LovEntity uniteDemandee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "batiment")
    private BatimentEntity batiment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parcelle")
    private ParcelleEntity parcelle;

    @ManyToMany
    @JoinTable(name = "installation_energie_produites",
        uniqueConstraints = @UniqueConstraint(columnNames = {"installation_id", "lov_dom_code"}, name = "installation_energie_produites_pkey"),
        joinColumns = {@JoinColumn(name = "installation_id")},
        inverseJoinColumns = {@JoinColumn(name = "lov_dom_code")}
    )
    private List<LovEntity> energieProduite;

    private String energieProduiteCommentaire;

    @ManyToMany
    @JoinTable(name = "installation_energie_utilisees",
        uniqueConstraints = @UniqueConstraint(columnNames = {"installation_id", "lov_dom_code"}, name = "installation_energie_utilisees_pkey"),
        joinColumns = {@JoinColumn(name = "installation_id")},
        inverseJoinColumns = {@JoinColumn(name = "lov_dom_code")}
    )
    private List<LovEntity> energieUtilisee;

    private String energieUtiliseeCommentaire;

    public String getLibelle() {
        return (StringUtils.isNotBlank(denomination) ? denomination : "");
    }

}
