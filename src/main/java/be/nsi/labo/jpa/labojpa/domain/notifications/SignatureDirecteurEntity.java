package be.nsi.labo.jpa.labojpa.domain.notifications;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@Getter
@Setter
public class SignatureDirecteurEntity implements Serializable {

    @Column(name = "signature_directeur_correction")
    private Boolean correction;

    @Column(name = "signature_directeur_remarque")
    private String remarque;

    @Column(name = "signature_directeur_signe_le")
    private LocalDate signeLe;

    @Column(name = "signature_directeur_signe_par")
    private String signePar;

    @Column(name = "signature_directeur_manuscrite")
    private boolean manuscrite;
}
