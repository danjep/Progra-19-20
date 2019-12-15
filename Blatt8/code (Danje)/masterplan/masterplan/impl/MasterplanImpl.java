package masterplan.impl;

import masterplan.*;


public class MasterplanImpl implements Masterplan{

    Lehrveranstaltung veranstaltungen[][];

    public MasterplanImpl(Lehrveranstaltung[][] vera) {
        veranstaltungen = new Lehrveranstaltung[vera.length][];
        for(Lehrveranstaltung[] i: veranstaltungen) {
            i = new Lehrveranstaltung[vera[i].length];
        }

        for(int i = 0; i < veranstaltungen.length; i++) {
            for(int j = 0; j < veranstaltungen[i].length; j++) {
                veranstaltungen[i][j] = vera[i][j];
            }
        }

    }

    public int getNumberOfSemesters() {
        return veranstaltungen.length;
    }

    public int getNumberOfLehrveranstaltungen(int semester) {
        if(0 <= semester && semester < veranstaltungen.length) {
            return veranstaltungen[semester].length;
        } else {
            throw IllegalArgumentException;
        }
    }

    public Lehrveranstaltung getLehrveranstaltung(int semester, int lehrveranstaltung) {
        if(0 <= semester && semester < veranstaltungen.length) {
            if(0 <= lehrveranstaltung && lehrveranstaltung < veranstaltungen[semester].length) {
                return veranstaltungen[semester][lehrveranstaltung];
            }
        }
        throw IllegalArgumentException;
    }
}
