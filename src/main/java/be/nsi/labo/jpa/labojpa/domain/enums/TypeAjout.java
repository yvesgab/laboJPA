package be.nsi.labo.jpa.labojpa.domain.enums;

public enum TypeAjout {
    AUTOMATIQUE ("AUTOMATIQUE"),
    MANUEL ("MANUEL");

    private final String typeAjout;

    TypeAjout(String typeAjout){
        this.typeAjout = typeAjout;
    }

    public String getTypeAjout() {
        return typeAjout;
    }
}
