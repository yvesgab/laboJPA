package be.nsi.labo.jpa.labojpa.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Base abstract class for entities which will hold definitions for created, last modified by and created,
 * last modified by date.
 */
@MappedSuperclass
@Audited
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class AbstractBaseAuditingEntity extends AbstractBaseEntity implements AuditingEntity, Serializable {

    /**
     * The create by.
     */
    @CreatedBy
    @Column(name = "create_by", nullable = true, length = 255, updatable = true)

    private String createBy;

    /**
     * The create at.
     */
    @CreatedDate
    @Convert(converter = LocalDateTimeConverter.class)
    @Column(name = "create_at", nullable = true)

    private LocalDateTime createAt = LocalDateTime.now();

    /**
     * The update by.
     */
    @LastModifiedBy
    @Column(name = "update_by", length = 255)

    private String updateBy;

    /**
     * The update at.
     */
    @LastModifiedDate
    @Convert(converter = LocalDateTimeConverter.class)
    @Column(name = "update_at")

    private LocalDateTime updateAt;

}
