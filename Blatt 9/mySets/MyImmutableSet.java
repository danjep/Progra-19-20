class MyImmutableSet<T> extends MyAbstractSet implements MyMinimalSet {

    public MyImmutableSet(MySetElement<T> head) {
        super(head);
    }
}