package be.nsi.labo.jpa.labojpa.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ContentStorage {
    TWICE("TWICE"),
    NOTICE("NOTICe"),
    NEP("NEP"),
    NEP_FORM("NEP_FORM");

    private String value;
}
