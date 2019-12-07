public class ModifiedTextDocument extends TextDocument {

    //////////////////////////////////
    // Attribute
    //////////////////////////////////

    private TextDocument last;

    //////////////////////////////////
    // Konstruktoren
    //////////////////////////////////

    public ModifiedTextDocument(String content, TextDocument last) {
        super(content);
        this.last = last;
    }

    //////////////////////////////////
    // public Methoden
    //////////////////////////////////

    @Override
    public TextDocument undo() {
        return last;
    }

}