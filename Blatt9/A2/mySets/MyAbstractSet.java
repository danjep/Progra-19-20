package mySets;

import java.util;
import java.lang;

abstract class MyAbstractSet<T> implements java.lang.Iterable, java.util.Set {

    public MySetIterator iterator() {
        //TODO
    }

    public int size() {
        //TODO
    }
    
    public boolean isEmpty() {
        //TODO
    }

    public boolean contains(java.lang.Object x) {
        //TODO
    }

    public java.lang.Object[] toArray() throws java.lang.UnsupportedOperationException {
        throw java.lang.UnsupportedOperationException;
    }

    public <T> T[] toArray(T[] arr) throws java.lang.UnsupportedOperationException {
        throw java.lang.UnsupportedOperationException;
    }


} 