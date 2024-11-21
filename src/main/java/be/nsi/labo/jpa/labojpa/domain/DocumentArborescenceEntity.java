package be.nsi.labo.jpa.labojpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DocumentArborescenceEntity.
 */
@Entity
@Table(name = "document_arborescence", uniqueConstraints = @UniqueConstraint(columnNames = {"dossier_type_name", "chemin_classement"}, name = "document_arborescence_unique_dossier_type_chemin"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentArborescenceEntity extends AbstractBaseAuditingEntity implements Serializable {

    @Column(name = "chemin_classement", nullable = false)
    private String cheminClassement;

    @Column(name = "repertoire", nullable = false)
    private String repertoire;

    @Column(name = "_level", nullable = false)
    private Integer level;

    @Column(name = "_order", nullable = false)
    private Integer order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dossier_type_name", nullable = false)
    private DossierTypeEntity dossierType;

    @Column(name = "can_contain_document", nullable = false, columnDefinition = "boolean default true")
    private boolean canContainDoc;
}
