public class Zinsrechner {

    public static void main(String[] args) {
        double startbetrag = SimpleIO.getDouble("Was ist ihr Startbetrag?");
        double zinssatz = SimpleIO.getDouble("Was ist ihr Zinssatz in Prozent?") / 100 + 1;
        String modus = SimpleIO.getString("Geben Sie 'Ziel' für den Zielmodus oder 'Zeit' für den Zeitmodus ein!");

        if (modus.equals("Ziel")) {
            double zielbetrag = SimpleIO.getDouble("Was ist ihr Zielbetrag?");
            double betrag = startbetrag;
            int jahre = 0;
            while (betrag < zielbetrag) {
                betrag *= zinssatz;
                jahre++;
            }
            SimpleIO.output(
                    "Es dauert " + jahre + " Jahre bei einem Zinssatz von " + Math.round(zinssatz * 10E5) / 10E5
                            + "%, um von " + startbetrag + " auf den Betrag " + zielbetrag
                            + " zu sparen. Nach dieser Zeit hat man " + Math.round(betrag * 100.0) / 100.0 + ".",
                    "Ergebnis");
        } else if (modus.equals("Zeit")) {
            int jahre = SimpleIO.getInt("Wie viele Jahre sollen berechnet werden?");
            double betrag = startbetrag;
            for (int i = 0; i < jahre; i++) {
                betrag *= zinssatz;
            }
            SimpleIO.output(
                    "Bei einem Zinssatz von " + Math.round(zinssatz * 10E5) / 10E5 + "% und einem Startbetrag von "
                            + startbetrag + " hat man nach " + jahre + " Jahren " + betrag + " gespart.",
                    "Ergebnis");
        } else {
            SimpleIO.output("Ihre Eingabe war Fehlerhaft!", "FEHLER");
        }
    }

}