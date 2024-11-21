package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DocumentTypeEntity.
 */
@Entity
@Table(name = "document_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentTypeEntity extends AbstractBaseAuditingEntity implements Serializable {

    @NotNull
    @Column(name = "code", updatable = false, nullable = false)
    private String code;

    @NotNull
    @Column(name = "label_fr", nullable = false)
    private String labelFr;

    @NotNull
    @Column(name = "label_de", nullable = false)
    private String labelDe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_arborescence_id", nullable = false)
    private DocumentArborescenceEntity documentArborescence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dossier_type_name", nullable = false)
    private DossierTypeEntity dossierType;

    @Column(name = "original", columnDefinition = "boolean default false")
    private boolean original;

    @Column(name = "_order", nullable = false)
    private Integer order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statut")
    private LovEntity statut;

    @Column(name = "demande", columnDefinition = "boolean default false")
    private boolean demande;

    @Column(name = "decision", columnDefinition = "boolean default false")
    private boolean decision;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DocumentTypeEntity other = (DocumentTypeEntity) obj;
        if (other.code == null || getCode() == null) {
            return false;
        } else return code.equals(other.code);
    }
}
