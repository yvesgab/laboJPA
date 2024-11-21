package be.nsi.labo.jpa.labojpa.domain.notifications;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class ValidationDGO4Entity implements Serializable {

    @Column(name = "validation_dgo4_correction")
    private Boolean correction;

    @Column(name = "validation_dgo4_remarque")
    private String remarque;
}
