package be.nsi.labo.jpa.labojpa.domain.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RubriqueExcelSheet {
    REFERENTIEL_RUBRIQUES("Référentiel Rubriques", 0, 0, 31),
    MOTS_CLES("Mots clés", 1, 0, 0),
    SECTEUR_ACTIVITE("Secteur d’activité", 2, 0, 0),
    ACTIVITE_PRINCIPALE("Activité principale", 3, 0, 0),
    TYPE_ACTIVITE("Type activité", 4, 0, 0),
    GLOSSAIRE("Glossaire", 5, 0, 1),
    ORGANISMES_A_CONSULTER("Organismes à Consulter", 6, 0, 1),
    UNITES("Unités", 7, 0, 2),
    IS("I-S", 8, 0, 3),
    LIEN_RUBRIQUERS_IS("Lien Rubriques I-S", 9, 0, 8),
    PARTICULIERES("Particulières", 10, 0, 5);

    public String name;
    public int index;
    public int firstCol;
    public int lastCol;
}
