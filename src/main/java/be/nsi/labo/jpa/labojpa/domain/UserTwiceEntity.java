package be.nsi.labo.jpa.labojpa.domain;

import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import java.io.Serializable;

/**
 * A UserEntity.
 */
@Entity
@Table(name = "user_twice")
@Getter     // Lombok
@Setter     // Lombok
@NoArgsConstructor      // Lombok
@AllArgsConstructor     // Lombok
public class UserTwiceEntity extends AbstractBaseAuditingEntity implements Serializable, AuditingEntity {

    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "cell_phone")
    private String cellPhone;

    @Column(name = "fax_number")
    private String faxNumber;

    @Column(name = "email_address")
    private String emailAddress;

    @ManyToOne
    @JoinColumn(name = "language")
    private LovEntity language;

    @ManyToOne
    @JoinColumn(name = "statut")
    private LovEntity statut;

    @OneToOne
    @JoinColumn(name = "authority")
    private UserEntity authority;

    @Formula("concat(last_name,' ',first_name)")
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "direction")
    private InstanceEntity direction;

    @ManyToOne
    @JoinColumn(name = "login_type")
    private LovEntity loginType;
}
