package be.nsi.labo.jpa.labojpa.domain.echeanciers;

import be.nsi.labo.jpa.labojpa.domain.AbstractAuditingEntity;
import be.nsi.labo.jpa.labojpa.domain.documents.DocumentEntity;
import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "echeanciers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EcheancierEntity extends AbstractAuditingEntity implements Serializable {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "libelle")
    private String libelle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statut")
    private LovEntity statut;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("ordre asc")
    @JoinColumn(name = "echeancier")
    private List<EcheancierEtapeEntity> etapes;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("code asc")
    @JoinColumn(name = "echeancier")
    private List<EcheancierGrilleDelaiEntity> grilles;

    @OneToOne
    @JoinColumn(name = "document_regles_calcul")
    private DocumentEntity documentReglesCalcul;

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
        EcheancierEntity other = (EcheancierEntity) obj;
        if (other.getCode() == null || getCode() == null) {
            return false;
        } else return code.equals(other.code);
    }
}
