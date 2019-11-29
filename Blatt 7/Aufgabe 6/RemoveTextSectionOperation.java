public class RemoveTextSectionOperation extends Operation {

    //////////////////////////////////
    // Attribute
    //////////////////////////////////

    private int beginIndex;
    private int endIndex;

    //////////////////////////////////
    // Konstruktoren
    //////////////////////////////////

    public RemoveTextSectionOperation(int beginIndex, int endIndex) {
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
    }

    //////////////////////////////////
    // public Methoden
    //////////////////////////////////

    @Override
    public TextDocument apply(TextDocument current) {
        return current.removeTextSection(beginIndex, endIndex);
    }

    @Override
    public String getDescription() {
        return "removes the text section from " + beginIndex + " to " + endIndex;
    }

}