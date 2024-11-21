package be.nsi.labo.jpa.labojpa.domain.enums;

public enum EcheanceRegroupement {
    DGO3_ECHEANCE_SEMAINE ("DGO3_ECHEANCE_SEMAINE"),
    DGO4_ECHEANCE_SEMAINE ("DGO4_ECHEANCE_SEMAINE"),
    CT ("CT"),
    CA ("CA");

    private final String name;

    EcheanceRegroupement(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
