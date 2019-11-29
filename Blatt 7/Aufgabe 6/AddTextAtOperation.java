public class AddTextAtOperation extends Operation {

    //////////////////////////////////
    // Attribute
    //////////////////////////////////

    private int position;
    private String addition;

    //////////////////////////////////
    // Konstruktoren
    //////////////////////////////////

    public AddTextAtOperation(int position, String addition) {
        this.position = position;
        this.addition = addition;
    }

    //////////////////////////////////
    // public Methoden
    //////////////////////////////////

    @Override
    public TextDocument apply(TextDocument current) {
        return current.addTextAt(position, addition);
    }

    @Override
    public String getDescription() {
        return "adds the folowing text at position " + position + ": " + addition;
    }

}