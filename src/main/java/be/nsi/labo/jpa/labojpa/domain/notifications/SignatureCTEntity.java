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
public class SignatureCTEntity implements Serializable {

    @Column(name = "signature_ct_correction")
    private Boolean correction;

    @Column(name = "signature_ct_remarque")
    private String remarque;

    @Column(name = "signature_ct_signe_le")
    private LocalDate signeLe;

    @Column(name = "signature_ct_signe_par")
    private String signePar;

    @Column(name = "signature_ct_manuscrite")
    private boolean manuscrite;
}
