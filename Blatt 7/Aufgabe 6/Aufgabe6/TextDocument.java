public class TextDocument {

    //////////////////////////////////
    // Attribute
    //////////////////////////////////

    private final String content;

    //////////////////////////////////
    // Konstruktoren
    //////////////////////////////////

    public TextDocument(String content) {
        this.content = content;
    }

    //////////////////////////////////
    // public Methoden
    //////////////////////////////////

    public TextDocument undo() {
        return this;
    }

    public ModifiedTextDocument noop() {
        return new ModifiedTextDocument(content, this);
    }

    public ModifiedTextDocument replaceTextSection(int beginIndex, int endIndex, String replacement) {
        String replacedContent = content.substring(0, beginIndex) + replacement + content.substring(endIndex - 1);

        return new ModifiedTextDocument(replacedContent, this);
    }

    public ModifiedTextDocument addTextAt(int position, String addition) {
        String addedContent = content.substring(0, position) + addition + content.substring(position);

        return new ModifiedTextDocument(addedContent, this);
    }

    public ModifiedTextDocument removeTextSection(int beginIndex, int endIndex) {
        String removedContent = content.substring(0, beginIndex) + content.substring(endIndex);

        return new ModifiedTextDocument(removedContent, this);
    }

    public String getContent() {
        return content;
    }

}