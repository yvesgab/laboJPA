package be.nsi.labo.jpa.labojpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ElectronicFormEntity {

    @Column(name = "electronic_form_number")
    private String number;

    @Column(name = "electronic_form_dossier_id", unique = true)
    private String id;

    @Column(name = "electronic_form_procedure_ref")
    private String procedureRef;

    @Column(name = "electronic_form_procedure_name")
    private String procedureName;

    @Column(name = "electronic_form_citizen_reference")
    private String citizenReference;

    @Column(name = "electronic_form_e_space_id")
    private String eSpaceId;

    @Column(name = "electronic_form_owner_profile_id")
    private String ownerProfileId;

    @Column(name = "electronic_form_form_id")
    private String formId;

    @Column(name = "electronic_form_form_name")
    private String formName;

}
