package be.nsi.labo.jpa.labojpa.domain.enums;

public enum DemandeurType {
    DOSSIER_DEMANDEUR_PERSON ("DOSSIER_DEMANDEUR_PERSON"),
    DOSSIER_DEMANDEUR_ENTERPRISE ("DOSSIER_DEMANDEUR_ENTERPRISE");

    private final String name;

    DemandeurType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
