package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.enums.TypeLienDossier;
import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Table(name = "dossier_lie", uniqueConstraints = @UniqueConstraint(columnNames = {"dossier_destination", "dossier_source"}, name = "dossier_lie_unique_dossier_source_destination"))
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class DossierLieEntity extends AbstractBaseAuditingEntity {

    @ManyToOne
    @JoinColumn(name = "dossier_destination", foreignKey = @ForeignKey(name = "dossier_lie_fk_dossier_destination"))
    private DossierEntity dossierDestination;

    @ManyToOne
    @JoinColumn(name = "dossier_source", foreignKey = @ForeignKey(name = "dossier_lie_fk_dossier_source"))
    private DossierEntity dossierSource;

    @Column(name = "type_lien")
    @Enumerated(EnumType.STRING)
    private TypeLienDossier typeLien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statut", foreignKey = @ForeignKey(name = "dossier_lie_fk_statut"))
    private LovEntity statut;
}
