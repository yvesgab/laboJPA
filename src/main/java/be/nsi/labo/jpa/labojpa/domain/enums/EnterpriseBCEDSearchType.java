package be.nsi.labo.jpa.labojpa.domain.enums;

public enum EnterpriseBCEDSearchType {
    SOCIAL_DENOMINATION("SOCIAL_DENOMINATION"),
    ENTERPRISE_NUMBER("ENTERPRISE_NUMBER");

    private final String name;

    EnterpriseBCEDSearchType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
