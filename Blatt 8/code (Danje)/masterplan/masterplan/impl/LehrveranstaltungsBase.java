package masterplan.impl;

import masterplan.Masterplan;

abstract class LehrveranstaltungsBase implements Lehrveranstaltung {

    int creditpoints;
    String Description;

    public LehrveranstaltungsBase(int cP, String title, String type) {
        this.creditpoints = cP;
        if(title.equals("Funktionale Programmierung") && type.equals("Vorlesung")) {
            Description = "Funktionale Programmierung (Vorlesung)";
        }
    }

    public int getCreditPoints() {

        return creditpoints;
    }

    public String getDescription() {

        return Beschreibung;
    }
}
