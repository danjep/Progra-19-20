public class B extends A {

    public String s;

    public B() {
        this("B()");
    }

    public B(String s) {
        super("B(String)");
        this.s = s;
    }

}