package be.nsi.labo.jpa.labojpa.domain.enums;

public enum SpwProperty {
    REFERENCE_ADM ("spw:refInt"),
    CREATEUR ("spw:createur"),
    CONTRIBUTEUR ("spw:modificateur"),
    TYPE_DOC_SPEC ("spw:sousTypeDoc"),
    TYPE_DOC ("spw:typeDoc"),
    LANGUE ("spw:langue"),
    MOT_CLES ("spw:motsCles");

    private final String value;

    SpwProperty(String value){
        this.value = value;
    }

    public String value() {
        return value;
    }
}
