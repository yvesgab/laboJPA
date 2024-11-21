package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.caracteristiques.AbstractCaracteristiqueEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

/**
 * A Batiment.
 */
@Entity
@Table(name = "batiment", uniqueConstraints =
@UniqueConstraint(columnNames = {"identifiant", "dossier"}))
@Getter     // Lombok
@Setter     // Lombok
@NoArgsConstructor      // Lombok
@AllArgsConstructor     // Lombok
public class BatimentEntity extends AbstractCaracteristiqueEntity implements AuditingEntity {

    @ManyToOne
    @JoinColumn(name = "parcelle", nullable = false)
    private ParcelleEntity parcelle;

    @Column(name = "denomination", columnDefinition = "TEXT")
    private String denomination;

    public String getLibelle() {
        // TWICE-1432 -> enlever 'parcelle' du libellé des bâtiments
        return (StringUtils.isNotBlank(denomination) ? denomination : "");
    }

}
