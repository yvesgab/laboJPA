package be.nsi.labo.jpa.labojpa.domain.referentiels;

import be.nsi.labo.jpa.labojpa.domain.AbstractAuditingEntity;
import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A CommuneEntity.
 */
@Entity
@Table(name = "commune")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommuneEntity extends AbstractAuditingEntity implements Serializable {

    @Id
    @Column(name = "code_ins")
    private String codeIns;

    @Column(name = "code_postal")
    private String codePostal;

    @Column(name = "nom_fr")
    private String nomFr;

    @Column(name = "nom_de")
    private String nomDe;

    @ManyToOne
    @JoinColumn(name = "statut")
    private LovEntity statut;

    @ManyToOne
    @JoinColumn(name = "region")
    private LovEntity region;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codeIns == null) ? 0 : codeIns.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        CommuneEntity other = (CommuneEntity) obj;
        if (other.getCodeIns() == null || getCodeIns() == null) {
            return false;
        } else return codeIns.equals(other.getCodeIns());
    }
}
