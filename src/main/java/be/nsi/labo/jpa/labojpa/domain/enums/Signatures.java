package be.nsi.labo.jpa.labojpa.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Signatures {
    EN_DATE("Signed on %date%"),
    EN_USER("by %person%"),
    DE_DATE(""),
    DE_USER(""),
    FR_DATE("Signé le %date%"),
    FR_USER("par %person%");

    public static final String PERSON = "%person%";
    public static final String DATE = "%date%";

    final String text;
}
