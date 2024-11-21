package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.caracteristiques.AbstractCaracteristiqueEntity;
import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

/**
 * A RejetEauEntity.
 */
@Entity
@Table(name = "rejet_eau", uniqueConstraints =
@UniqueConstraint(columnNames = {"identifiant", "dossier"}))
@Getter     // Lombok
@Setter     // Lombok
@NoArgsConstructor      // Lombok
@AllArgsConstructor     // Lombok)
public class RejetEauEntity extends AbstractCaracteristiqueEntity implements AuditingEntity {

    @Column(name = "nom_usuel_description")
    private String nomUsuelDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_rejet_eau")
    private LovEntity typeRejetEau;

    public String getLibelle() {
        return (StringUtils.isNotBlank(nomUsuelDescription) ? nomUsuelDescription : "");
    }

}
