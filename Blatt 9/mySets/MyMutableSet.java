import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.lang.UnsupportedOperationException;

public class MyMutableSet extends MyAbstractSet implements Set {

    public MyMutableSet() {
        super(null);
    }

    public boolean add(T e) {
        if (contains(e)) {
            return false;
        } else {
            MySetElement<T> eSet = null;
            for (MySetElement<T> se : this) {
                eSet = se;
            }
            eSet.next = new MySetElement<T>(e);
        }
    }

    public boolean addAll(Collection c) {
        changed = false;
        for (MySetElement<T> e : c) {
            if (add(e)) {
                changed = true;
            }
        }
        return changed;
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
        for (MySetElement<T> e : this) {
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

}