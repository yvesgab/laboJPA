package be.nsi.labo.jpa.labojpa.domain.notifications;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class ValidationDirecteurEntity implements Serializable {

    @Column(name = "validation_directeur_correction")
    private Boolean correction;

    @Column(name = "validation_directeur_remarque")
    private String remarque;
}
