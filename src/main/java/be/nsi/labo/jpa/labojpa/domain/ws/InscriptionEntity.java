package be.nsi.labo.jpa.labojpa.domain.ws;

import be.nsi.labo.jpa.labojpa.domain.AbstractAuditingEntity;
import be.nsi.labo.jpa.labojpa.domain.AuditingEntity;
import be.nsi.labo.jpa.labojpa.domain.LocalDateTimeConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "inscription")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InscriptionEntity extends AbstractAuditingEntity implements AuditingEntity {

    @Id
    @Column(name = "number")
    private String number;

    @Column(name = "reference")
    private String reference;

    @Convert(converter = LocalDateTimeConverter.class)
    @Column(name = "fin_validite")
    private LocalDateTime finValidite;
}
