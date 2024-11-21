package be.nsi.labo.jpa.labojpa.domain.ws;

import be.nsi.labo.jpa.labojpa.domain.AbstractBaseAuditingEntity;
import be.nsi.labo.jpa.labojpa.domain.documents.DocumentEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "environmental_licence_document")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnvironmentalLicenceDocumentEntity extends AbstractBaseAuditingEntity {

    @ManyToOne
    @JoinColumn(name = "environmental_licence", foreignKey = @ForeignKey(name = "environmental_licence_document_fk_environmental_licence"))
    private EnvironmentalLicenceEntity environmentalLicenceEntity;

    @OneToOne
    @JoinColumn(name = "document", foreignKey = @ForeignKey(name = "environmental_licence_document_fk_document"))
    private DocumentEntity documentEntity;
}
