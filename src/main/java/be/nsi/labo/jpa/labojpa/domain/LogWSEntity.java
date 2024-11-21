package be.nsi.labo.jpa.labojpa.domain;


import be.nsi.labo.jpa.labojpa.converter.JsonMapConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.Type;
import org.hibernate.type.descriptor.jdbc.JsonJdbcType;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * A LogWSEntity.
 */
@Entity
@Table(name = "log_ws")
@Getter
@Setter
public class LogWSEntity extends AbstractBaseEntity implements Serializable {

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "operation_name")
    private String operationName;

    @Column(columnDefinition = "text")
    @Fetch(FetchMode.JOIN)
    @Convert(converter = JsonMapConverter.class)
    private Map<String,String> labels;

    @Column(name = "direction")
    private String direction;

    @Column(name = "request", columnDefinition = "text")
    private String request;

    @Column(name = "response", columnDefinition = "text")
    private String response;

    @Column(name = "error", columnDefinition = "text")
    private String error;

    @Column(name = "in_error")
    private boolean inError;

    @Column(name = "create_by", nullable = false, updatable = false)
    private String createBy;

    @Column(name = "create_at", nullable = false, updatable = false)
    private LocalDateTime createAt;
}
