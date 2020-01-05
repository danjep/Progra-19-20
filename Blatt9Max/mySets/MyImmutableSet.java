package mySets;

import java.lang.instrument.UnmodifiableClassException;
import java.util.Collection;
import java.util.Iterator;

public class MyImmutableSet<T> extends MyAbstractSet implements MyMinimalSet {

    public MyImmutableSet(MySetElement<T> head) {
        super(head);
    }

    public void addAllTo(Collection col) throws UnmodifiableCollectionException {
        Iterator i = iterator();
        try {
            while (i.hasNext()) {
                col.add((T) i.next());
            }
        } catch (UnsupportedOperationException e) {
            throw new UnmodifiableCollectionException("This collection cant be modified!");
        }
    }

    public void clear() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("This collection cant be modified!");
    }

    public boolean removeAll(Collection c) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("This collection cant be modified!");
    }

    public boolean add(Object e) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("This collection cant be modified!");
    }

    public boolean addAll(Collection c) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("This collection cant be modified!");
    }

    public boolean remove(Object e) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("This collection cant be modified!");
    }

    public boolean retainAll(Collection c) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("This collection cant be modified!");
    }

    public Object[] toArray(Object[] e) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("This collection cant be modified!");
    }

}