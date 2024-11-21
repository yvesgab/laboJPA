package be.nsi.labo.jpa.labojpa.domain.enums;

public enum EtablissementRoute {
    IDENTIFICATION ("identification"),
    DOSSIERS ("dossiers"),
    INSTALLATIONS ("installations"),
    DEPOTS_SUBSTANCES ("depots-substances"),
    DEPOTS_DECHETS ("depots-dechets"),
    BATIMENTS ("batiments"),
    REJETS_EAU ("rejets-eau"),
    DEVERSEMENTS ("deversements"),
    REJETS_ATMOSPHERIQUES ("rejets-atmospheriques"),
    PARCELLES ("parcelles"),
    RUBRIQUES ("rubriques"),
    CLASSEMENTS ("classements"),
    DOCUMENTS_JOINTS ("documents-joints"),
    HISTORIQUE_SURETE("historique-surete"),
    DOCUMENTS_DECISION("documents-decision")
    ;

    private final String route;

    EtablissementRoute(String route){
        this.route = route;
    }

    public String getRoute() {
        return route;
    }
}
