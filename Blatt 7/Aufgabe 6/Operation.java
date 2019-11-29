public class Operation {

    //////////////////////////////////
    // Attribute
    //////////////////////////////////

    //////////////////////////////////
    // public Methoden
    //////////////////////////////////

    public TextDocument apply(TextDocument current) {
        return current.noop();
    }

    public String getDescription() {
        return "does not modify the document";
    }

}