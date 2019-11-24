/**
 * Implementation eines Rectangles
 * 
 * @author Maximilian Petri (405602)
 * @author Danje Petersen (379748)
 */
public class Rectangle {

    //////////////////////////////////////////////////////////////////
    // Attribute
    //////////////////////////////////////////////////////////////////

    private int x, y;
    private int width, height;

    //////////////////////////////////////////////////////////////////
    // Konstruktoren
    //////////////////////////////////////////////////////////////////

    /**
     * 
     * @param xInput      x-Koordinate des Rectangles.
     * @param yInput      y-Koordinate des Rectangles.
     * @param widthInput  Breite des Rectangles (&gt;= 0).
     * @param heightInput Höhe des Rectangles (&gt;= 0).
     */
    public Rectangle(int xInput, int yInput, int widthInput, int heightInput) {
        x = xInput;
        y = yInput;
        if (checkLength(widthInput)) {
            width = widthInput;
        } else {
            Utils.error("[Rectangle] width < 0");
            return;
        }
        if (checkLength(heightInput)) {
            height = heightInput;
        } else {
            Utils.error("[Rectangle] height < 0");
            return;
        }
    }

    /**
     * 
     * @param xInput          x-Koordinate des Rectangles.
     * @param yInput          y-Koordinate des Rectangles.
     * @param sidelengthInput Seitenlänge des Rectangles, also der width und height
     *                        Wert (&gt;= 0).
     * 
     */
    public Rectangle(int xInput, int yInput, Integer sidelengthInput) {
        x = xInput;
        y = yInput;
        if (checkLength(sidelengthInput)) {
            width = sidelengthInput.intValue();
            height = sidelengthInput.intValue();
        } else {
            Utils.error("[Rectangle] width, height < 0");
            return;
        }
    }

    //////////////////////////////////////////////////////////////////
    // static Methoden
    //////////////////////////////////////////////////////////////////

    /**
     * Kopiert ein Rectangle und gibt die Kopie zurück.
     * 
     * @param toCopy Rectangle, welches kopiert werden soll.
     * @return Neues Rectangle mit den selben Eigenschaften wie toCopy.
     */
    public static Rectangle copy(Rectangle toCopy) {
        return new Rectangle(toCopy.getX(), toCopy.getY(), toCopy.getWidth(), toCopy.getHeight());
    }

    /**
     * Berechnet die Vereinigung der übergebenen Rectangles
     * 
     * @param rectangles Rectangles, welche vereinigt werden sollen.
     * @return Die Vereiningung der Rectangles, also das größte Rectangle das alle
     *         beinhaltet.
     */
    public static Rectangle union(Rectangle... rectangles) {
        if (rectangles.length < 1) {
            return null;
        } else if (rectangles.length == 1) {
            return rectangles[0];
        } else {
            Rectangle unionRectangle = unite(rectangles[0], rectangles[1]);
            for (int i = 2; i < rectangles.length; i++) {
                unionRectangle = unite(unionRectangle, rectangles[i]);
            }
            return unionRectangle;
        }
    }

    /**
     * Berechnet die Schnittmenge der übergebenen Rectangles
     * 
     * @param rectangles Rectangles, welche geschnitten werden sollen.
     * @return Die Schnittmenge der Rectangles, also das größte Rectangle das in
     *         allen enthalten ist.
     */
    public static Rectangle intersection(Rectangle... rectangles) {
        if (rectangles.length < 1) {
            return null;
        } else if (rectangles.length == 1) {
            return rectangles[0];
        } else {
            Rectangle intersectRectangle = intersect(rectangles[0], rectangles[1]);
            for (int i = 2; i < rectangles.length; i++) {
                intersectRectangle = intersect(intersectRectangle, rectangles[i]);
            }
            return intersectRectangle;
        }
    }

    //////////////////////////////////////////////////////////////////
    // public Methoden
    //////////////////////////////////////////////////////////////////

    /**
     * Gibt einen String, der das Rectangle anhand seiner Eckpunkte darstellt,
     * zurück.
     * 
     * @return Einen String mit den Eckpunkten des Rectangles.
     */
    public String toString() {
        String p1 = "(" + (x + width) + "," + (y - height) + ")";
        String p2 = "(" + (x + width) + "," + (y) + ")";
        String p3 = "(" + (x) + "," + (y) + ")";
        String p4 = "(" + (x) + "," + (y - height) + ")";

        return p1 + "," + p2 + "," + p3 + "," + p4;
    }

    /**
     * Bestimmt die RectangleSpecies dieses Rectangles.
     * 
     * @return Die RectangleSpecies zu welcher dieses Rectangle gehört.
     */
    public RectangleSpecies determineSpecies() {
        if (width == 0 && height == 0) {
            return RectangleSpecies.POINT;
        } else if (width == 1 && height == 1) {
            return RectangleSpecies.PIXEL;
        } else if (width >= 1 && height == 0) {
            return RectangleSpecies.HLINE;
        } else if (width == 0 && height >= 1) {
            return RectangleSpecies.VLINE;
        } else if (width >= 2 && width == height) {
            return RectangleSpecies.SQUARE;
        } else if (width >= 2 && height == 1) {
            return RectangleSpecies.ROW;
        } else if (width == 1 && height >= 2) {
            return RectangleSpecies.COLUMN;
        } else {
            return RectangleSpecies.OTHER;
        }
    }

    //////////////////////////////////////////////////////////////////
    // private Methoden
    //////////////////////////////////////////////////////////////////

    private static Rectangle unite(Rectangle r1, Rectangle r2) {
        // Get Vaules for intersection of r1 and r2
        int left = Utils.min(r1.getX(), r2.getX());
        int top = Utils.max(r1.getY(), r2.getY());
        int right = Utils.max(r1.getX() + r1.getWidth(), r2.getX() + r2.getWidth());
        int bottom = Utils.min(r1.getY() - r1.getHeight(), r2.getY() - r2.getHeight());

        return new Rectangle(left, top, right - left, top - bottom);
    }

    private static Rectangle intersect(Rectangle r1, Rectangle r2) {
        if (r1 == null || r2 == null) {
            return null;
        }

        // Get Vaules for intersection of r1 and r2
        int left = Utils.max(r1.getX(), r2.getX());
        int top = Utils.min(r1.getY(), r2.getY());
        int right = Utils.min(r1.getX() + r1.getWidth(), r2.getX() + r2.getWidth());
        int bottom = Utils.max(r1.getY() - r1.getHeight(), r2.getY() - r2.getHeight());

        System.out.println("(" + right + "," + bottom + ")");
        System.out.println("(" + right + "," + top + ")");
        System.out.println("(" + left + "," + top + ")");
        System.out.println("(" + left + "," + bottom + ")");

        // Check if Dimensions ar correct
        if (right - left >= 0 && top - bottom >= 0) {
            return new Rectangle(left, top, right - left, top - bottom);
        } else {
            return null;
        }
    }

    private boolean checkLength(int length) {
        return length >= 0;
    }

    //////////////////////////////////////////////////////////////////
    // getter + setter
    //////////////////////////////////////////////////////////////////

    /**
     * Liefert die x-Koordinate des Rectangles
     * 
     * @return x-Koordinate des Rectangles.
     */
    public int getX() {
        return x;
    }

    /**
     * Setzt die x-Koordinate des Rectangles
     * 
     * @param x Der neue Wert der x-Koordinate.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * 
     * Liefert die y-Koordinate des Rectangles
     * 
     * @return y-Koordinate des Rectangles.
     */
    public int getY() {
        return y;
    }

    /**
     * 
     * Liefert die y-Koordinate des Rectangles
     * 
     * @param y Der neue Wert der x-Koordinate.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Liefert die Breite des Rectangles
     * 
     * @return Breite des Rectangles.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Setzt die Breite des Rectangles
     * 
     * @param width Die neue Breite des Rectangles.
     */
    public void setWidth(int width) {
        if (checkLength(width)) {
            this.width = width;
        } else {
            Utils.error("[Rectangle] width < 0");
            return;
        }
    }

    /**
     * Liefert die Höhe des Rectangles
     * 
     * @return Höhe des Rectangles.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Setzt die Höhe des Rectangles
     * 
     * @param height Die neue Höhe des Rectangles.
     */
    public void setHeight(int height) {
        if (checkLength(height)) {
            this.height = height;
        } else {
            Utils.error("[Rectangle] height < 0");
            return;
        }
    }
}