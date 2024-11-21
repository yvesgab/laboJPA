package be.nsi.labo.jpa.labojpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "liens_hypertexte")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LienHypertexteEntity extends AbstractBaseAuditingEntity {

    @Column(name = "liens", columnDefinition = "TEXT")
    private String liens;
}
