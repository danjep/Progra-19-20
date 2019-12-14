package masterplan;

public class LehrveranstaltungMitBereichszuordnung extends LehrveranstaltungBase {

    private Bereich field;

    public LehrveranstaltungMitBereichszuordnung(int creditPoints, String title, String type, Bereich field) {
        super(creditPoints, title, String.format("%s im Bereich %s", type, field.getDescription()));
        this.field = field;
    }

    public Bereich getField() {
        return field;
    }

}