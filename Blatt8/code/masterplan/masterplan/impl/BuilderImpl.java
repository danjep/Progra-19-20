package masterplan.impl;

import masterplan.*;
import java.util.HashMap;
import java.util.Collections;

public class BuilderImpl implements MasterplanBuilder, SemesterBuilder {

    private Lehrveranstaltung[][] semesters = new Lehrveranstaltung[10][10];

    private int currentSemester = 0;
    private int currentLehrveranstaltung = 0;

    public BuilderImpl beginSemester() throws InvalidMasterplanException {
        if (currentSemester >= semesters.length) {
            throw new InvalidMasterplanException(String.format("Mehr als %s sind nicht erlaubt!", semesters.length));
        } else {
            return this;
        }
    }

    public BuilderImpl endSemester() throws InvalidMasterplanException {
        currentSemester++;
        currentLehrveranstaltung = 0;
        return this;
    }

    public BuilderImpl anwendungsfach(int creditPoints, String title) throws InvalidMasterplanException {
        if (currentLehrveranstaltung >= semesters[currentSemester].length) {
            throw new InvalidMasterplanException(String.format("Mehr als %s Lehrveranstaltungen sind nicht erlaubt!",
                    semesters[currentSemester].length));
        } else {
            semesters[currentSemester][currentLehrveranstaltung] = new Anwendungsfach(creditPoints, title);
            currentLehrveranstaltung++;
            return this;
        }
    }

    public BuilderImpl masterarbeit(String title) throws InvalidMasterplanException {
        if (currentLehrveranstaltung >= semesters[currentSemester].length) {
            throw new InvalidMasterplanException(String.format("Mehr als %s Lehrveranstaltungen sind nicht erlaubt!",
                    semesters[currentSemester].length));
        } else {
            semesters[currentSemester][currentLehrveranstaltung] = new Masterarbeit(title);
            currentLehrveranstaltung++;
            return this;
        }
    }

    public BuilderImpl praktikum(String title) throws InvalidMasterplanException {
        if (currentLehrveranstaltung >= semesters[currentSemester].length) {
            throw new InvalidMasterplanException(String.format("Mehr als %s Lehrveranstaltungen sind nicht erlaubt!",
                    semesters[currentSemester].length));
        } else {
            semesters[currentSemester][currentLehrveranstaltung] = new Praktikum(title);
            currentLehrveranstaltung++;
            return this;
        }
    }

    public BuilderImpl schwerpunktkolloquium(String title) throws InvalidMasterplanException {
        if (currentLehrveranstaltung >= semesters[currentSemester].length) {
            throw new InvalidMasterplanException(String.format("Mehr als %s Lehrveranstaltungen sind nicht erlaubt!",
                    semesters[currentSemester].length));
        } else {
            semesters[currentSemester][currentLehrveranstaltung] = new Schwerpunktkolloquium(title);
            currentLehrveranstaltung++;
            return this;
        }
    }

    public BuilderImpl seminar(String title, Bereich field) throws InvalidMasterplanException {
        if (currentLehrveranstaltung >= semesters[currentSemester].length) {
            throw new InvalidMasterplanException(String.format("Mehr als %s Lehrveranstaltungen sind nicht erlaubt!",
                    semesters[currentSemester].length));
        } else {
            semesters[currentSemester][currentLehrveranstaltung] = new Seminar(title, field);
            currentLehrveranstaltung++;
            return this;
        }
    }

    public BuilderImpl wahlpflichtvorlesung(int creditPoints, String title, Bereich field)
            throws InvalidMasterplanException {
        if (currentLehrveranstaltung >= semesters[currentSemester].length) {
            throw new InvalidMasterplanException(String.format("Mehr als %s Lehrveranstaltungen sind nicht erlaubt!",
                    semesters[currentSemester].length));
        } else {
            semesters[currentSemester][currentLehrveranstaltung] = new Wahlpflichtvorlesung(creditPoints, title, field);
            currentLehrveranstaltung++;
            return this;
        }
    }

    public Masterplan validateAndCreate() throws InvalidMasterplanException {
        Lehrveranstaltung[][] packedLehrveranstaltungen = pack(this.semesters);
        Masterplan m = new MasterplanImpl(packedLehrveranstaltungen);

        check(m);

        return m;
    }

    private Lehrveranstaltung[][] pack(Lehrveranstaltung[][] toPackSemesters) {
        int sCount = 0;
        while (sCount < 10 && toPackSemesters[sCount][0] != null) {
            sCount++;
        }
        Lehrveranstaltung[][] packedSemesters = new Lehrveranstaltung[sCount][];
        for (int s = 0; s < sCount; s++) {
            int lCount = 0;
            while (toPackSemesters[s][lCount] != null) {
                lCount++;
            }
            packedSemesters[s] = new Lehrveranstaltung[lCount];
            for (int l = 0; l < lCount; l++) {
                packedSemesters[s][l] = toPackSemesters[s][l];
            }
        }
        return packedSemesters;
    }

    private void check(Masterplan m) throws InvalidMasterplanException {
        int creditPoints = 0;
        int anwendungPoints = 0;
        int praktikumCount = 0;
        int seminarCount = 0;
        int schwerpunktkolloquiumCount = 0;
        int masterarbeitCount = 0;
        HashMap<Bereich, Integer> fields = new HashMap<>();

        for (int s = 0; s < m.getNumberOfSemesters(); s++) {
            for (int l = 0; l < m.getNumberOfLehrveranstaltungen(s); l++) {
                Lehrveranstaltung lehrveranstaltung = m.getLehrveranstaltung(s, l);
                creditPoints += lehrveranstaltung.getCreditPoints();

                if (lehrveranstaltung instanceof LehrveranstaltungMitBereichszuordnung) {
                    Bereich f = ((LehrveranstaltungMitBereichszuordnung) lehrveranstaltung).getField();
                    if (!fields.containsKey(f)) {
                        fields.put(f, lehrveranstaltung.getCreditPoints());
                    } else {
                        fields.put(f, fields.get(f) + lehrveranstaltung.getCreditPoints());
                    }
                }

                if (lehrveranstaltung instanceof Praktikum) {
                    praktikumCount++;
                } else if (lehrveranstaltung instanceof Seminar) {
                    seminarCount++;
                } else if (lehrveranstaltung instanceof Schwerpunktkolloquium) {
                    schwerpunktkolloquiumCount++;
                } else if (lehrveranstaltung instanceof Masterarbeit) {
                    masterarbeitCount++;
                } else if (lehrveranstaltung instanceof Anwendungsfach) {
                    anwendungPoints += lehrveranstaltung.getCreditPoints();
                }
            }
        }

        if (creditPoints < 120) {
            throw new InvalidMasterplanException("weniger als 120 Credit Points!");
        } else if (fields.size() < 3) {
            throw new InvalidMasterplanException("Veranstaltungen aus weniger als 3 Bereichen!");
        } else if (!fields.containsKey(Bereich.THEORETISCHE_INFORMATIK)
                || fields.get(Bereich.THEORETISCHE_INFORMATIK) < 12) {
            throw new InvalidMasterplanException("weniger als 12 Credit Points im Bereich Theoretische Informatik!");
        } else if (Collections.max(fields.values()) >= 35) {
            throw new InvalidMasterplanException("mehr als 35 Credit Points in einem Bereich!");
        } else if (anwendungPoints != 18) {
            throw new InvalidMasterplanException("Credit Points im Anwendungsfach sind nicht 18!");
        } else if (seminarCount != 1) {
            throw new InvalidMasterplanException("nicht genau 1 Seminar besucht!");
        } else if (praktikumCount != 1) {
            throw new InvalidMasterplanException("nicht genau 1 Praktikum besucht!");
        } else if (schwerpunktkolloquiumCount != 1) {
            throw new InvalidMasterplanException("nicht genau 1 Schwerpunktkolloquium gehalten!");
        } else if (masterarbeitCount != 1) {
            throw new InvalidMasterplanException("nicht genau 1 Masterarbeit geschrieben!");
        }
    }

}