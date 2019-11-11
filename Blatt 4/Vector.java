public class Vector {

    private double[] components;

    public static void main(String[] args) {
        int dim = SimpleIO.getInt("Geben Sie die Dimension der Vektoren ein:");
        Vector v1 = Vector.newWithDimension(dim);
        Vector v2 = Vector.newWithDimension(dim);

        SimpleIO.output("Geben Sie die Komponenten des ersten Vektors ein:");
        v1.readComponentsFromUserInput();
        SimpleIO.output("Geben Sie die Komponenten des zweiten Vektors ein:");
        v2.readComponentsFromUserInput();

        SimpleIO.output("Das Skalarprodukt der beiden Vektoren ist: " + v1.scalarproduct(v2));
    }

    public static Vector newWithDimension(int n) {
        Vector v = new Vector();
        v.initComponents(n);
        return v;
    }

    public double scalarproduct(Vector q) {
        // check if same length
        if (this.getLength() != q.getLength()) {
            return 0;
        }

        // calculate Scalaproduct
        double scalarproduct = 0;
        for (int i = 0; i < this.getLength(); i++) {
            scalarproduct += this.getComponent(i) * q.getComponent(i);
        }
        return scalarproduct;
    }

    public void readComponentsFromUserInput() {
        for (int i = 0; i < this.getLength(); i++) {
            components[i] = SimpleIO.getDouble("Geben sie die " + (i + 1) + "-te Komponente ein:");
        }
    }

    public void initComponents(int n) {
        components = new double[n];
    }

    public int getLength() {
        return components.length;
    }

    public void setComponent(double val, int i) {
        components[i] = val;
    }

    public double getComponent(int i) {
        return components[i];
    }

}