package masterplan;

public class MasterplanImpl implements Masterplan {

    public MasterplanImpl(Lehrveranstaltung[][] vera) {
        Lehrveranstaltung veranstaltungen[][] = new Lehrveranstaltung[vera.length][];
        for(Lehrveranstaltung[] i: veranstaltungen) {
            i = new Lehrveranstaltung[vera[i].length];
        }

        for(int i = 0; i < veranstaltungen.length; i++) {
            for(int j = 0; j < veranstaltungen[i].length; j++) {
                veranstaltungen[i][j] = vera[i][j];
            }
        }

    }
}
