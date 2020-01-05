import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.lang.UnsupportedOperationException;

public class MyMutableSet<T> extends MyAbstractSet implements Set {

    public MyMutableSet() {
        super(null);
    }

    public boolean add(Object e) {
        if (contains(e)) {
            return false;
        } else {
            MySetElement<T> eSet = null;
            Iterator i = this.iterator();
            while (i.hasNext()) {
                eSet = (MySetElement<T>) i.next();
            }
            eSet.next = new MySetElement<T>((T) e);
            return true;
        }
    }

    public boolean addAll(Collection c) {
        boolean changed = false;
        Iterator i = c.iterator();
        while (i.hasNext()) {
            if (add(i.next())) {
                changed = true;
            }
        }
        return changed;
    }

    public MyImmutableSet<T> freezeAndClear() {
        MyImmutableSet<T> frozen = new MyImmutableSet(head);
        clear();
        return frozen;
    }

    public void clear() {
        head = null;
    }

    public boolean remove(Object o) {
        MySetElement<T> before = null;
        if (o.equals(head)) {
            head = head.next;
            return true;
        }
        Iterator i = iterator();
        while (i.hasNext()) {
            MySetElement<T> e = (MySetElement<T>) i.next();
            if (o.equals(e)) {
                before.next = e.next;
                return true;
            }
            before = e;
        }
        return false;
    }

    public boolean removeAll(Collection c) {
        Iterator i = c.iterator();
        boolean changed = false;
        while (i.hasNext()) {
            if (remove(i.next())) {
                changed = true;
            }
        }
        return changed;
    }

    public boolean retainAll(Collection c) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public <T> T[] toArray​(Object[] a) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public Object[] toArray() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

}