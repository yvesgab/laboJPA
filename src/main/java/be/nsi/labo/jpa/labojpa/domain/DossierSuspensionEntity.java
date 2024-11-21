package be.nsi.labo.jpa.labojpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "dossier_suspension")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DossierSuspensionEntity extends AbstractBaseAuditingEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "dossier_type_suspension")
    private DossierTypeSuspensionEntity dossierTypeSuspension;

    @Column(name = "date_debut")
    private Date dateDebut;

    @Column(name = "date_fin")
    private Date dateFin;

    @ManyToOne
    @JoinColumn(name = "dossier")
    private DossierEntity dossier;
}
