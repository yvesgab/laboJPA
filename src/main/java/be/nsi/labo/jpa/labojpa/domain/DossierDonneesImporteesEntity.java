package be.nsi.labo.jpa.labojpa.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A DonneeImportee.
 */
@Entity
@Table(name = "dossier_donnees_importees")
@Getter     // Lombok
@Setter     // Lombok
@NoArgsConstructor      // Lombok
@AllArgsConstructor     // Lombok
public class DossierDonneesImporteesEntity extends AbstractBaseAuditingEntity implements AuditingEntity {

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dossier")
    private DossierEntity dossier;

}
