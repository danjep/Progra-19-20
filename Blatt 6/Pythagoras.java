/**
 * Program for drawing a Pythagoras tree.
 */
public class Pythagoras {

    /**
     * @param args Contains the parameters for the drawing. The first (mandatory) is
     *             the recursion level. All further parameters are optional and have
     *             default values in case they are not given. Second is the base
     *             length of the first square, third and fourth are the angles of
     *             the left and right subtrees, respectively, and fifth is the
     *             length at which to switch colors from brown to green. Default
     *             values are 100, 45, 45, and 10. The two angles must not sum up to
     *             more than 120 and each parameter must be positive. Moreover, both
     *             angles must be less than 90.
     */
    public static void main(String[] args) {
        int level;
        int length = 100;
        int leftAngle = 45;
        int rightAngle = 45;
        int switchLength = 10;
        switch (args.length) {
        case 5:
            switchLength = Integer.parseInt(args[4]);
            // fall-through
        case 4:
            rightAngle = Integer.parseInt(args[3]);
            // fall-through
        case 3:
            leftAngle = Integer.parseInt(args[2]);
            // fall-through
        case 2:
            length = Integer.parseInt(args[1]);
            // fall-through
        case 1:
            level = Integer.parseInt(args[0]);
            break;
        default:
            System.out.println("Es muessen zwischen 1 und 5 Parameter angegeben werden "
                    + "(Level, Basislaenge, linker Winkel, rechter Winkel, " + "Laenge fuer Farbwechsel)!");
            return;
        }
        if (level < 1) {
            System.out.println("Das Rekursionslevel muss positiv sein!");
            return;
        }
        if (length < 1) {
            System.out.println("Die Basislaenge muss positiv sein!");
            return;
        }
        if (leftAngle < 1) {
            System.out.println("Der linke Winkel muss positiv sein!");
            return;
        }
        if (rightAngle < 1) {
            System.out.println("Der rechte Winkel muss positiv sein!");
            return;
        }
        if (leftAngle >= 90) {
            System.out.println("Der linke Winkel muss kleiner als 90 sein!");
            return;
        }
        if (rightAngle >= 90) {
            System.out.println("Der rechte Winkel muss kleiner als 90 sein!");
            return;
        }
        if (leftAngle + rightAngle > 120) {
            System.out.println("Die beiden Winkel duerfen zusammen nicht mehr als 120 ergeben!");
            return;
        }
        Canvas c = new Canvas();
        Pythagoras.paintPythagorasTree(c, level, length, leftAngle, rightAngle, switchLength);
        c.refresh();
    }

    /**
     * Diese Methode zeichnet einen Pythagors Baum auf ein Canvas mit verschiedenen
     * Einstellungsmöglichkeiten.
     * 
     * @param c            Das Canvas auf dem der Pythagoras Baum gezeichnet werden
     *                     soll.
     * @param level        Die Tiefe der Rekursion.
     * @param length       Die Größe des ersten Rechtecks.
     * @param leftAngle    Die Größe des linken Winkels.
     * @param rightAngle   Die Größe des rechten Winkels.
     * @param switchLength Die Länge ab welcher alle größeren Rechtecke Braun seien
     *                     sollen.
     */
    private static void paintPythagorasTree(Canvas c, int level, double length, int leftAngle, int rightAngle,
            int switchLength) {

        // check for level
        if (level < 1) {
            return;
        }

        // set color
        if (length <= switchLength) {
            c.chooseColor(c.GREEN);
        } else {
            c.chooseColor(c.BROWN);
        }

        // draw Square
        c.square(length);

        // Right
        double rightLength = calculateLength(leftAngle, rightAngle, length);
        c.move(length / 2, -length / 2);
        c.rotate(rightAngle);
        c.move(-rightLength / 2, -rightLength / 2);

        paintPythagorasTree(c, level - 1, rightLength, leftAngle, rightAngle, switchLength);

        c.move(rightLength / 2, rightLength / 2);
        c.rotate(-rightAngle);
        c.move(-length / 2, length / 2);

        // Left
        double leftLength = calculateLength(rightAngle, leftAngle, length);
        c.move(-length / 2, -length / 2);
        c.rotate(-leftAngle);
        c.move(leftLength / 2, -leftLength / 2);

        paintPythagorasTree(c, level - 1, leftLength, leftAngle, rightAngle, switchLength);

        c.move(-leftLength / 2, leftLength / 2);
        c.rotate(leftAngle);
        c.move(length / 2, length / 2);
    }

    private static double calculateLength(int alpha, int beta, double length) {
        return (Math.sin(Math.toRadians(alpha)) * length) / (Math.sin(Math.toRadians(180 - alpha - beta)));
    }

}
