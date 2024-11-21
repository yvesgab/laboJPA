package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.echeanciers.EcheancierEntity;
import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "dossier_type_echeancier",
       uniqueConstraints = @UniqueConstraint(columnNames = {"dossier_type_name", "echeancier_code"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DossierTypeEcheancierEntity extends AbstractBaseAuditingEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "dossier_type_name")
    private DossierTypeEntity dossierType;

    @ManyToOne
    @JoinColumn(name = "echeancier_code")
    private EcheancierEntity echeancier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statut", columnDefinition = "varchar2(103) default '#STATUT_ACTIF#ACTIF#'")
    private LovEntity statut;

    @Column(name = "defaut")
    private boolean defaut;
}
