package mySets;

public class MySetElement<T> {

    private T value;
    MySetElement<T> next;

    public MySetElement(T value, MySetElement<T> next) {
        this.value = value;
        this.next = next;
    }

    public MySetElement(T value) {
        this.value = value;
    }

}