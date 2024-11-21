package be.nsi.labo.jpa.labojpa.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EtapeImportDossierEnum {
    FORMAT_CANONIQUE("Format canonique"),
    PIECE_JOINTES("Pièces jointes"),
    TYPE_DOSSIER ("Type de dossier"),
    ENVOI_NOTICE("Envoi NOTICe"),
    MAJ_STATUT_NEP_COMMUNE("Mise à jour du Statut NEP commune"),
    CREATION_DOSSIER("Création dossier"),
    MAJ_DOSSIER("Mise à jour du dossier"),
    MAJ_STATUT_NEP_DPA("Mise à jour du Statut NEP commune DPA"),
    FIN_TRAITEMENT("Fin de traitement");

    final String name;
}

