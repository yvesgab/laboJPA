package be.nsi.labo.jpa.labojpa.domain.enums;

public enum DossierRoute {
    INFORMATIONS ("informations"),
    DONNEES_IMPORTEES ("donnees-importees"),
    DEMANDEURS ("demandeurs"),
    DOSSIERS_LIES ("dossiers-lies"),
    PARCELLES ("parcelles"),
    BATIMENTS ("batiments"),
    INSTALLATIONS ("installations"),
    DEPOTS_SUBSTANCES ("depots-substances"),
    DEPOTS_DECHETS ("depots-dechets"),
    REJETS_EAU ("rejets-eau"),
    DEVERSEMENTS("deversements"),
    REJETS_ATMOSPHERIQUES ("rejets-atmospheriques"),
    RUBRIQUES ("rubriques"),
    CLASSEMENTS ("classements"),
    DOCUMENTS ("documents"),
    ECHEANCES_ETAPES ("echeances-etapes"),
    NOTIFICATIONS ("notifications"),
    NOTIFICATIONS_URBANISME ("notifications-urbanisme"),
    COMPLETUDE1 ("completude1"),
    COMPLETUDE2 ("completude2"),
    ENQUETES_PUBLIQUES ("enquetes-publiques"),
    DEMANDES_AVIS ("demandes-avis"),
    NOTES ("notes"),
    PROROGATION ("prorogation"),
    TEXTES_LEGAUX ("textes-legaux"),
    SUSPENSION ("suspension"),
    RS_DECISION ("rs-decision"),
    DECISION ("decision"),
    AR_RECOURS ("ar-recours"),
    NOTIFICATIONS_LIBRES ("notifications-libres"),
    SOLLICITEURS ("solliciteurs"),
    FUSIONS ("fusions"),
    RIP ("rip"),
    CONDITIONS_PARTICULIERES ("conditions-particulieres"),
    FIN_ANTICIPEE ("fin-anticipee")
    ;

    private final String route;

    DossierRoute(String route){
        this.route = route;
    }

    public String getRoute() {
        return route;
    }
}
