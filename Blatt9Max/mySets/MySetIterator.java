package mySets;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;

public class MySetIterator<T> implements Iterator {

    private MySetElement<T> current;

    public MySetIterator(MySetElement<T> current) {
        this.current = current;
    }

    public boolean hasNext() {
        return current != null;
    }

    public MySetElement<T> next() throws NoSuchElementException {
        if (current != null) {
            MySetElement<T> ret = current;
            current = current.next;
            return ret;
        } else {
            throw new NoSuchElementException();
        }
    }

    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

}