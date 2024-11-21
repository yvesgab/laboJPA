package be.nsi.labo.jpa.labojpa.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InstanceTypeEnum {
    COMMUNE("COMMUNE"),
    DPA("DPA"),
    DNF("DNF"),
    DGO4_DE("DGO4_DE"),
    DYNAMIQUE("DYNAMIQUE");

    final String code;
}
