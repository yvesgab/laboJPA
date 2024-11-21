package be.nsi.labo.jpa.labojpa.domain.notifications;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * A ValidationFDEntity.
 */
@Embeddable
@Getter
@Setter
public class ValidationFDEntity implements Serializable {

    @Column(name = "validation_fd_correction")
    private Boolean correction;

    @Column(name = "validation_fd_remarque")
    private String remarque;

}
