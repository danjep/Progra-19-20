public class ReplaceTextSectionOperation extends Operation {

    //////////////////////////////////
    // Attribute
    //////////////////////////////////

    private int beginIndex;
    private int endIndex;
    private String replacement;

    //////////////////////////////////
    // Konstruktoren
    //////////////////////////////////

    public ReplaceTextSectionOperation(int beginIndex, int endIndex, String replacement) {
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
        this.replacement = replacement;
    }

    //////////////////////////////////
    // public Methoden
    //////////////////////////////////

    @Override
    public TextDocument apply(TextDocument current) {
        return current.replaceTextSection(beginIndex, endIndex + 1, replacement);
    }

    @Override
    public String getDescription() {
        return "replaces the text section from " + beginIndex + " to " + endIndex + " by: " + replacement;
    }

}