package be.nsi.labo.jpa.labojpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DossierEtablissementEntity.
 */
@Entity
@Table(name = "dossier_etablissement")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DossierEtablissementEntity extends AbstractBaseAuditingEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_dossier")
    private DossierEntity dossier;

    @ManyToOne
    @JoinColumn(name = "id_etablissement")
    private EtablissementEntity etablissement;

    @Column(name = "dossier_reference", columnDefinition = "boolean default false")
    private boolean dossierReference;
}
