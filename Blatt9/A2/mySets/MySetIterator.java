package mySets;

import java.util;
import java.util.NoSuchElementException;

// b)
class MySetIterator<T> implements Iterator{
    MySetElement<T> current;


    MySetIterator(T nun) {
        this.current = new MySetElement(nachst, nun);

    }

    public boolean hasNext() {
        if(current != NULL) {
            return true;
        } else {
            return false;
        }
    }

    public T next() throws java.util.NoSuchElementException {
        if(current == null) {
            throw java.util.NoSuchElementException;
        } else {
            T temp = current;
            current = current.next;
            return temp;
        }
    }

    public void remove() throws java.lang.UnsupportedOperationExcepion {
        throw java.lang.UnsupportedOperationException;
    }
}