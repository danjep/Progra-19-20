public class Launcher {

    public static void main(String[] args) {

        Operation[] operations = new Operation[5];
        operations[0] = new AddTextAtOperation(0, "Hello Aachen!");
        operations[1] = new ReplaceTextSectionOperation(6, 12, "World");
        operations[2] = new UndoOperation();
        operations[3] = new ReplaceTextSectionOperation(0, 5, "Goodbye");
        operations[4] = new RemoveTextSectionOperation(14, 15);

        TextDocument doc = new TextDocument("");

        for (Operation op : operations) {
            doc = op.apply(doc);
            System.out.println(op.getDescription());
            System.out.println(doc.getContent());
        }

    }

}