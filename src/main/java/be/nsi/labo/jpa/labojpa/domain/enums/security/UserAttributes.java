package be.nsi.labo.jpa.labojpa.domain.enums.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserAttributes {
    CONNECTION_TYPE("client_registration_id"),
    SPW_AD("spw-ad"),
    SPW_FAS("spw-fas"),
    CREDENTIALS_TYPE("credentials_type"),
    LASTNAME("family_name"),
    FIRSTNAME("given_name"),
    EMAIL("email");

    private String attribute;
}
