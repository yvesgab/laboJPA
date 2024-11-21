package be.nsi.labo.jpa.labojpa.domain.views;

import be.nsi.labo.jpa.labojpa.domain.AbstractBaseEntity;
import org.springframework.data.annotation.Immutable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "dossier_lie_view")
@Immutable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DossierLieView extends AbstractBaseEntity {

    @Column(name = "dossier_id")
    private Long dossierId;

    @Column(name = "dossier_numero")
    private String dossierNumero;

    @Column(name = "dossier_lie_id")
    private Long dossierLieId;

    @Column(name = "dossier_lie_numero")
    private String dossierLieNumero;

    @Column(name = "dossier_lie_numero_objet_fr")
    private String dossierLieNumeroObjetFr;

    @Column(name = "dossier_lie_numero_objet_de")
    private String dossierLieNumeroObjetDe;

    @Column(name = "dossier_type_name")
    private String dossierTypeName;

    @Column(name = "dossier_type_libelle_fr")
    private String dossierTypeLibelleFr;

    @Column(name = "dossier_type_libelle_de")
    private String dossierTypeLibelleDe;

    @Column(name = "dossier_type_traitement_recours")
    private Boolean dossierTypeTraitementRecours;

    @Column(name = "type_lien")
    private String typeLien;

    @Column(name = "date_creation")
    private LocalDateTime dateCreation;

    @Column(name = "date_decision")
    private LocalDateTime dateDecision;

    @Column(name = "statut_code")
    private String statutCode;

    @Column(name = "statut_fr")
    private String statutFr;

    @Column(name = "statut_de")
    private String statutDe;
}
