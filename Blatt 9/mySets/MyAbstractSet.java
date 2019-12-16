import java.lang.Iterable;
import java.util.Set;
import java.util.Collection;
import java.util.Iterator;
import java.lang.UnsupportedOperationException;

abstract class MyAbstractSet<T> implements Iterable, Set {

    private MySetElement<T> head;

    public MyAbstractSet(MySetElement<T> head) {
        this.head = head;
    }

    public MySetIterator iterator() {
        return new MySetIterator<T>(head);
    }

    public int size() {
        int s = 0;
        for (MySetElement<T> e : this) {
            s++;
        }
        return s;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean contains(Object o) {
        for (MySetElement<T> e : this) {
            if (o.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(Collection c) {
        for (MySetElement<T> e : this) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    public Object[] toArray() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public <T> T[] toArray​(T[] a) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

}