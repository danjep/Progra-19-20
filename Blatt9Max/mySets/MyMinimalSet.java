import java.lang.Iterable;
import java.util.Collection;

public interface MyMinimalSet<T> extends Iterable {

    public boolean contains(Object o);

    public void addAllTo(Collection<T> col) throws UnmodifiableCollectionException;
}