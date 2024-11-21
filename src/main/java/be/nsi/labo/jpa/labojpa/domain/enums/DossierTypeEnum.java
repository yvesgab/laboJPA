package be.nsi.labo.jpa.labojpa.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DossierTypeEnum {
    RECOURS("RECOURS");

    final String name;
}
