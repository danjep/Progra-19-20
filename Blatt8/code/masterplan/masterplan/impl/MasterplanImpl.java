package masterplan.impl;

import masterplan.Lehrveranstaltung;
import masterplan.Masterplan;

public class MasterplanImpl implements Masterplan {

    private Lehrveranstaltung[][] lehrveranstaltungen;

    public MasterplanImpl(Lehrveranstaltung[][] lehrveranstaltungen) {
        this.lehrveranstaltungen = lehrveranstaltungen;
    }

    public int getNumberOfSemesters() {
        return lehrveranstaltungen.length;
    }

    public int getNumberOfLehrveranstaltungen(int semester) throws IllegalArgumentException {
        if (semester < 0) {
            throw new IllegalArgumentException("Index kleiner 0!");
        } else if (semester >= lehrveranstaltungen.length) {
            throw new IllegalArgumentException("Index größer oder gleich der Semesteranzahl!");
        } else {
            return lehrveranstaltungen[semester].length;
        }
    }

    public Lehrveranstaltung getLehrveranstaltung(int semester, int lehrverantaltung) {
        if (semester < 0) {
            throw new IllegalArgumentException("Semester-Index kleiner 0!");
        } else if (semester >= lehrveranstaltungen.length) {
            throw new IllegalArgumentException("Semester-Index größer oder gleich der Semesteranzahl!");
        } else if (lehrverantaltung < 0) {
            throw new IllegalArgumentException("Lehrveranstaltungs-Index kleiner 0!");
        } else if (lehrverantaltung >= lehrveranstaltungen[semester].length) {
            throw new IllegalArgumentException(
                    "Lehrveranstaltungs-Index größer oder gleich der Lehrverantaltungsanzahl für dieses Semester!");
        } else {
            return lehrveranstaltungen[semester][lehrverantaltung];
        }
    }
}