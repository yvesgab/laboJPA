package be.nsi.labo.jpa.labojpa.domain.notifications;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A SignatureFDEntity.
 */
@Embeddable
@Getter
@Setter
public class SignatureFDEntity implements Serializable {

    @Column(name = "signature_fd_correction")
    private Boolean correction;

    @Column(name = "signature_fd_remarque")
    private String remarque;

    @Column(name = "signature_fd_signe_le")
    private LocalDate signeLe;

    @Column(name = "signature_fd_signe_par")
    private String signePar;

    @Column(name = "signature_fd_manuscrite")
    private boolean manuscrite;

    @Column(name = "signature_fd_electronique")
    private boolean electronique;

}
