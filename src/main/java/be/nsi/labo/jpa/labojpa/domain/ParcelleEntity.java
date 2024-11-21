package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.caracteristiques.AbstractCaracteristiqueEntity;
import be.nsi.labo.jpa.labojpa.domain.referentiels.CommuneEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

/**
 * A Plot.
 */
@Entity
@Table(name = "parcelle", uniqueConstraints = @UniqueConstraint(columnNames = {"identifiant", "dossier"}))
@Getter     // Lombok
@Setter     // Lombok
@NoArgsConstructor      // Lombok
@AllArgsConstructor     // Lombok
public class ParcelleEntity extends AbstractCaracteristiqueEntity implements AuditingEntity {

    @ManyToOne
    @JoinColumn(name = "commune")
    private CommuneEntity commune;

    @Column(name = "division")
    private String division;

    @Column(name = "code_division")
    private String codeDivision;

    @Column(name = "section")
    private String section;

    @Column(name = "radical")
    private String radical;

    @Column(name = "bis_ter")
    private String bisTer;

    @Column(name = "exposant")
    private String exposant;

    @Column(name = "puissance")
    private String puissance;

    @Column(name = "part")
    private Boolean part;

    @Column(name = "droit_reel")
    private Boolean droitReel;

    @Column(name = "encodage")
    private Boolean encodage;

    @Column(name = "carto")
    private Boolean carto;

    @Transient
    public String getCapakey() {
        return Optional.ofNullable(codeDivision).map(b -> StringUtils.leftPad(b, 5,'0')).orElse("00000") +
            Optional.ofNullable(section).map(b -> StringUtils.leftPad(b, 1,'_')).orElse("_") +
            Optional.ofNullable(radical).map(b -> StringUtils.leftPad(b, 4,'0')).orElse("0000") +
            "/" +
            Optional.ofNullable(bisTer).map(b -> StringUtils.leftPad(b, 2,'0')).orElse("00") +
            Optional.ofNullable(exposant).map(e -> StringUtils.leftPad(e, 1,'_')).orElse("_") +
            Optional.ofNullable(puissance).map(p -> StringUtils.leftPad(p, 3,'0')).orElse("000");
    }

    public String getLibelle() {
        String capaKey = getCapakey();
        return !StringUtils.isEmpty(capaKey) ? capaKey : "";
    }

}
