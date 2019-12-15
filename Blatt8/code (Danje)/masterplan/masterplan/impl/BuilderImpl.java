package masterplan.impl;

import masterplan.*;
import masterplan.impl.Anwendungsfach;

public class BuilderImpl implements MasterplanBuilder, SemesterBuilder {
    Lehrveranstaltung semesters[][] = new Lehrveranstaltung[10][10];
    int currentSemester = 0;
    int currentLehrveranstaltung = 0;

    public SemesterBuilder beginSemester() {
        for(int i = 0; i < semesters.length; i++) {
            if(semesters[i] == currentSemester) {
                return this;
            }
        }
        throw InvalidMasterplanException;
    }

    public MasterplanBuilder endSemester() {
        currentSemester++;
        currentLehrveranstaltung = 0;
        return this;
    }

    public boolean platzcheck() {
        if(currentLehrveranstaltung < 9) {
            return true;
        } else {
            return false;
        }
        
    }

    public SemesterBuilder anwendungsfach(int creditPoints, String title) throws InvalidMasterplanException {
        if(platzcheck()) {
        semesters[currentSemester][currentLehrveranstaltung] = new Anwendungsfach(creditPoints, title, "Anwendungsfach");
        currentLehrveranstaltung++;
        return this;
        }
        else {
            throw InvalidMasterplanException;
        }
    }

    public SemesterBuilder masterarbeit(String title) throws InvalidMasterplanException {
        if(platzcheck()) {
        semesters[currentSemester][currentLehrveranstaltung] = new Masterarbeit(30, title, "Masterarbeit");
        currentLehrveranstaltung++;
        return this;
        } else {
            throw InvalidMasterplanException;
        }
    }

    public SemesterBuilder praktikum(String title) throws InvalidMasterplanException {
        if(platzcheck()) {
            semesters[currentSemester][currentLehrveranstaltung] = new Praktikum(7, title, "Praktikum");
            currentLehrveranstaltung++;
            return this;
        } else {
            throw InvalidMasterplanException;
        }
    }

    public SemesterBuilder schwerpunktkolloquium(String title) throws InvalidMasterplanException {
        if(platzcheck()) {
            semesters[currentSemester][currentLehrveranstaltung] = new Schwerpunktkolloquium(3, title, "Schwerpunktkolloquium");
            currentLehrveranstaltung++;
            return this;
        } else {
            throw InvalidMasterplanException;
        }
    }

    public SemesterBuilder seminar(String title, Bereich bereich) throws InvalidMasterplanException {
        if(platzcheck()) {
            semesters[currentSemester][currentLehrveranstaltung] = new Seminar(4, title, "Seminar", bereich);
            currentLehrveranstaltung++;
            return this;
        } else {
            throw InvalidMasterplanException;
        }
    }

    public SemesterBuilder wahlpflichtvorlesung(int creditPoints, String title, Bereich bereich) throws InvalidMasterplanException {
        if(platzcheck()) {
            semesters[currentSemester][currentLehrveranstaltung] = new Wahlpflichtvorlesung(creditPoints, title, "Wahlpflichtvorlesung", bereich);
            currentLehrveranstaltung++;
            return this;
        } else {
            throw InvalidMasterplanException;
        }
    }

	public Masterplan validateAndCreate() throws InvalidMasterplanException {
        int ii = 0;
        int sems[] = new int[10]; 
        for(int i = 0; i < semesters.length; i++) {
            if(semesters[i] != NULL) {
                for(int j = 0; j < 10; j++) {
                    if(semesters[i][j] != NULL) {
                        sems[i]++;
                    }
                }
            } else {
                ii = i;
                break;
            }
        }
        Lehrveranstaltung shorty[][] = new Lehrveranstaltung[ii+1][];

        for(int i = 0; i < shorty.length; i++) {
            shorty[i] = new int[sems[i].length];
        }

        for(int i = 0; i < shorty.length; i++) {
            for(int j = 0; j < shorty[i].length; j++) {
                shorty[i][j] = semesters[i][j];
            }
        }

        int af, ti, ges

        for(Lehrveranstaltung l: shorty) {
            switch(l) {
                case Anwendungsfach:

            }
        }


        Masterplan x = new Masterplan(shorty);
        return x;
    }

}