package be.nsi.labo.jpa.labojpa.domain;


import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * A ArRecours.
 */
@Entity
@Table(name = "ar_recours")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArRecoursEntity extends AbstractBaseAuditingEntity implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recours_suspensif", columnDefinition = "varchar2(103)")
    private LovEntity recoursSuspensif;

    @Column(name = "date_annulation")
    private Date dateAnnulation;

    @ManyToOne
    @JoinColumn(name = "dossier")
    private DossierEntity dossier;

}
