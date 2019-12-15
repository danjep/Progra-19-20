package mySets;

// a)
class MySetElement<T> {
    MySetElement<T> next;
    T value;

    public MySetElement(MySetElement<T> nachst, T wert) {
        this.next = nachst;
        this.value = wert;
    }

}