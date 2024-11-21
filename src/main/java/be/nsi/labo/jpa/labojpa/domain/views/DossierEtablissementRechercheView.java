package be.nsi.labo.jpa.labojpa.domain.views;

import be.nsi.labo.jpa.labojpa.domain.AbstractBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Immutable;

import java.util.Date;

@Entity
@Table(name = "dossier_etablissement_recherche_view")
@Immutable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DossierEtablissementRechercheView extends AbstractBaseEntity {

    @Column(name = "id")
    private Long id;

    @Column(name = "dossier_etablissement_dossier_reference")
    private boolean dossierEtablissementDossierReference;

    @Column(name = "dossier")
    private String dossier;

    @Column(name = "dossier_id")
    private Long dossierId;

    @Column(name = "dossier_dgo3_reception")
    private Date dossierDgo3Reception;

    @Column(name = "dossier_dgo3_decision")
    private Date dossierDgo3Decision;

    @Column(name = "dossier_numero_dossier")
    private String dossierNumeroDossier;

    @Column(name = "dossier_type")
    private String dossierType;

    @Column(name = "dossier_type_name")
    private String dossierTypeName;

    @Column(name = "etablissement_id")
    private Long etablissementId;

    @Column(name = "etablissement_id_dgo3")
    private String etablissementIdDgo3;

    @Column(name = "can_be_dossier_reference")
    private boolean canBeDossierReference;
}
