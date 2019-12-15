package masterplan;

public class Wahlpflichtvorlesung extends LehrveranstaltungMitBereichszuordnung {

    public Wahlpflichtvorlesung(int creditPoints, String title, Bereich field) {
        super(creditPoints, title, "Wahlpflichtvorlesung", field);
    }

}