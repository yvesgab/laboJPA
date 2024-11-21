package be.nsi.labo.jpa.labojpa.domain.notifications;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * A ValidationFTEntity.
 */
@Embeddable
@Getter
@Setter
public class ValidationFTEntity implements Serializable {

    @Column(name = "validation_ft_correction")
    private Boolean correction;

    @Column(name = "validation_ft_remarque")
    private String remarque;

}
