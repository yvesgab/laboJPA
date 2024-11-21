package be.nsi.labo.jpa.labojpa.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "dossier_prorogation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DossierProrogationEntity extends AbstractBaseAuditingEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "dossier", nullable = false)
    private DossierEntity dossier;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "duree")
    private Long duree;

    @Column(name = "justification", columnDefinition = "TEXT")
    private String justification;
}
