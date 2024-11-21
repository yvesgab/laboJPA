package be.nsi.labo.jpa.labojpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A NoteEntity.
 */
@Entity
@Table(name = "note")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteEntity extends AbstractBaseAuditingEntity  implements AuditingEntity {

    @Column(name = "note", columnDefinition="TEXT")
    private String note;

    @ManyToOne
    @JoinColumn(name = "dossier")
    private DossierEntity dossier;

}
