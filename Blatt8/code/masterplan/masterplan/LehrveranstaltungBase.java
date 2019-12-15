package masterplan;

public abstract class LehrveranstaltungBase implements Lehrveranstaltung {

    private int creditPoints;
    private String description;

    public LehrveranstaltungBase(int creditPoints, String title, String type) {
        this.creditPoints = creditPoints;
        this.description = String.format("%s (%s)", title, type);
    }

    public int getCreditPoints() {
        return creditPoints;
    }

    public String getDescription() {
        return description;
    }

}