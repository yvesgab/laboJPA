package be.nsi.labo.jpa.labojpa.domain.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TypeLienDossier {
    PRECEDENT("Précédent"),
    SUIVANT("Suivant"),
    FUSION_ORIGINE("Fusion (origine)"),
    FUSION_DESTINATION("Fusion (destination)"),
    AUTRE("Autre");

    public final String label;
}
