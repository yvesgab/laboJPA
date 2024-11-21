package be.nsi.labo.jpa.labojpa.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * The Class AbstractBaseEntity.
 */
@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
public abstract class AbstractBaseEntity implements Serializable {

    /**
     * The id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_generator")
    @SequenceGenerator(name = "hibernate_generator", sequenceName = "hibernate_sequence", initialValue = 100)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AbstractBaseEntity other = (AbstractBaseEntity) obj;
        if (other.getId() == null || getId() == null) {
            return false;
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }
}
