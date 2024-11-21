//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package be.nsi.labo.jpa.labojpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public abstract class AbstractSecurityBaseEntity <Long> {
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "jcubeSecuritySeqGen"
    )
    @SequenceGenerator(
        name = "jcubeSecuritySeqGen",
        sequenceName = "security_sequence",
        initialValue = 100
    )
    @Column(
        name = "id",
        updatable = false,
        nullable = false
    )
    private Long id;

}
