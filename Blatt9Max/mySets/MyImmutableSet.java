import java.lang.instrument.UnmodifiableClassException;
import java.util.Collection;
import java.util.Iterator;

class MyImmutableSet<T> extends MyAbstractSet implements MyMinimalSet {

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

}