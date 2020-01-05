import java.lang.Iterable;
import java.util.Set;
import java.util.Collection;
import java.util.Iterator;
import java.lang.UnsupportedOperationException;

abstract class MyAbstractSet<T> implements Iterable, Set {

    protected MySetElement<T> head;

    public MyAbstractSet(MySetElement<T> head) {
        this.head = head;
    }

    public MySetIterator iterator() {
        return new MySetIterator<T>(head);
    }

    public int size() {
        int s = 0;
        Iterator i = iterator();
        while (i.hasNext()) {
            s++;
            i.next();
        }
        return s;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean contains(Object o) {
        Iterator i = iterator();
        while (i.hasNext()) {
            if (o.equals(i.next())) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(Collection c) {
        Iterator i = iterator();
        while (i.hasNext()) {
            if (!contains(i.next())) {
                return false;
            }
        }
        return true;
    }
}
