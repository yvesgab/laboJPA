package be.nsi.labo.jpa.labojpa.domain.documents;

import be.nsi.labo.jpa.labojpa.domain.AbstractBaseAuditingEntity;
import be.nsi.labo.jpa.labojpa.domain.DocumentTypeEntity;
import be.nsi.labo.jpa.labojpa.domain.DossierEntity;
import be.nsi.labo.jpa.labojpa.domain.enums.DossierRoute;
import be.nsi.labo.jpa.labojpa.domain.notifications.NotificationDocumentEntity;
import be.nsi.labo.jpa.labojpa.domain.params.LovEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * A Document.
 */
@Entity
@Table(name = "document")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentEntity extends AbstractBaseAuditingEntity implements Serializable {

    @Column(name = "filename", nullable = false)
    private String filename;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "dossier")
    private DossierEntity dossier;

    @Column(name = "dossier_route")
    @Enumerated(EnumType.STRING)
    private DossierRoute dossierRoute;

    @ManyToOne
    @JoinColumn(name = "type")
    private DocumentTypeEntity type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "confidentiality", nullable = false)
    private LovEntity confidentiality;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language")
    private LovEntity language;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "file_size")
    private Long fileSize;

    @Column(name = "mime_type")
    private String mimeType;

    @Column(name = "document_key")
    private byte[] documentKey;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_document")
    private Set<NotificationDocumentEntity> liensNotifications = new HashSet<>();

    @Column(name = "uuid_nep")
    private String uuidNep;

    @Column(name = "signature_ct")
    private LocalDateTime signatureCT;

    @Column(name = "signature_directeur")
    private LocalDateTime signatureDirecteur;

    @Column(name = "signature_ft")
    private LocalDateTime signatureFT;

    @Column(name = "signature_fd")
    private LocalDateTime signatureFD;

    @Column(name = "non_signable_electroniquement", columnDefinition = "boolean default false")
    private boolean nonSignableElectroniquement;

    @Column(name = "attachment_NEP_FO", columnDefinition = "boolean default false")
    private boolean attachmentNepFo;

}
