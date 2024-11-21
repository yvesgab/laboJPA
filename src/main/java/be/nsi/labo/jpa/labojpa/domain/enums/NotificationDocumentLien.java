package be.nsi.labo.jpa.labojpa.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum NotificationDocumentLien {
    PRINCIPAL("principal"),
    JOINT("joint"),
    ORIGINAL("original");

    final String type;

    public static NotificationDocumentLien ofType(String type) {
        return Arrays.stream(values()).filter(enumValue -> enumValue.getType().equals(type)).findFirst().orElse(null);
    }
}
