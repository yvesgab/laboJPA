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
public class ErreurEnvoiEntity implements Serializable {

    @Column(name = "envoi_erreur_date")
    private LocalDate date;

    @Column(name = "envoi_erreur_message", columnDefinition = "TEXT")
    private String message;
}
