package be.nsi.labo.jpa.labojpa.domain.referentiels;

import be.nsi.labo.jpa.labojpa.domain.AbstractBaseAuditingEntity;
import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A LocaliteEntity.
 */
@Entity
@Table(name = "localite", uniqueConstraints= @UniqueConstraint(columnNames={"code_postal", "nom_fr", "commune_code_ins"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocaliteEntity extends AbstractBaseAuditingEntity implements Serializable {

    @Column(name = "code_postal", length = 10)
    private String codePostal;

    @Column(name = "nom_fr")
    private String nomFr;

    @Column(name = "nom_de")
    private String nomDe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statut")
    private LovEntity statut;

    @ManyToOne
    @JoinColumn(name = "commune_code_ins")
    private CommuneEntity commune;

}
