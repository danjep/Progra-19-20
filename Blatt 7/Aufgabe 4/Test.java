public class Test {
    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.s);
        System.out.println(((B) a).s);
    }
}