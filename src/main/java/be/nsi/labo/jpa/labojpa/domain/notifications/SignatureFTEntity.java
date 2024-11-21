package be.nsi.labo.jpa.labojpa.domain.notifications;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A SignatureFTEntity.
 */
@Embeddable
@Getter
@Setter
public class SignatureFTEntity implements Serializable {

    @Column(name = "signature_ft_correction")
    private Boolean correction;

    @Column(name = "signature_ft_remarque")
    private String remarque;

    @Column(name = "signature_ft_signe_le")
    private LocalDate signeLe;

    @Column(name = "signature_ft_signe_par")
    private String signePar;

    @Column(name = "signature_ft_manuscrite")
    private boolean manuscrite;

    @Column(name = "signature_ft_electronique")
    private boolean electronique;
}
