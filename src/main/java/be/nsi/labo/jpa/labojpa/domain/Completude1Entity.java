package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A Completude1Entity.
 */
@Entity
@Table(name = "completude_1")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Completude1Entity extends AbstractBaseAuditingEntity implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "avis_coordonne")
    private LovEntity avisCoordonne;

    @Column(name = "demande_eie")
    private Boolean demandeEIE;

    @ManyToOne
    @JoinColumn(name = "dossier", unique = true)
    private DossierEntity dossier;

    @Column(name = "mise_a_jour_caracteristiques")
    private LocalDate miseAJourCaracteristiques;
}
