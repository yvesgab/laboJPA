package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A Completude2Entity.
 */
@Entity
@Table(name = "completude_2")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Completude2Entity extends AbstractBaseAuditingEntity implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "avis_coordonne")
    private LovEntity avisCoordonne;

    @ManyToOne
    @JoinColumn(name = "dossier", unique = true)
    private DossierEntity dossier;
}
