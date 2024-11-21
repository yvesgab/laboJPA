package be.nsi.labo.jpa.labojpa.domain.enums.geoviewer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CoredParcelleAttributeEnum {
    COMMUNE("COMMUNE"),
    DIV_NOM("DIV_NOM"),
    CODE_DIV("CODE_DIV"),
    SECT("SECT"),
    RADICAL("RADICAL"),
    BIS("BIS"),
    EXPOSANT("EXPOSANT"),
    PUISSANCE("PUISSANCE");

    private final String value;
}
