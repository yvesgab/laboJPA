package be.nsi.labo.jpa.labojpa.domain.echeanciers;

import be.nsi.labo.jpa.labojpa.domain.AbstractBaseAuditingEntity;
import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "echeancier_grille_delai",
       uniqueConstraints = @UniqueConstraint(columnNames = {"echeancier", "code"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EcheancierGrilleDelaiEntity extends AbstractBaseAuditingEntity implements Serializable {

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "libelle")
    private String libelle;

    @ManyToOne
    @JoinColumn(name = "statut")
    private LovEntity statut;

    @Column(name = "defaut")
    private boolean defaut;

    @Column(name = "echeancier")
    private String echeancierCode;
}
