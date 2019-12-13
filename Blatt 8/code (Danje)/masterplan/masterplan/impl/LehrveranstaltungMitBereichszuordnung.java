package masterplan.impl;

import masterplan.Masterplan;

abstract class LehrveranstaltungMitBereichszuordnung extends LehrveranstaltungsBase {

    Bereich bereich;

    public LehrveranstaltungMitBereichszuordnung(int creditPoints, String title, String type, Bereich bereich) {

        super(creditPoints, title, switcheroo(type, bereich.getDescription()));
        this.bereich = bereich;
    }

    public String switcheroo(String type, String bereich) {
        switch(bereich) {
            case THEORETISCHE_INFORMATIK:
                type = type + " im Bereich Theoretische Informatik";
                break;
            case SOFTWARE_UND_KOMMUNIKATION:
                type = type + " im Bereich Software und Kommunikation";
                break;
            case DATEN_UND_INFORMATIONSMANAGEMENT:
                type = type + " im Bereich Daten- und Informationsmanagement";
                break;
            case ANGEWANDTE_INFORMATIK:
                type = type + " im Bereich Angewandte Informatik";
                break;
        }
        return type;
    }

    public Bereich getBereich() {
        return bereich;
    }
}
