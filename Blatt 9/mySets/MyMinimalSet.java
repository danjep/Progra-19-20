import java.lang.Iterable;

public interface MyMinimalSet<T> extends Iterable{

    public boolean isContained(MySetElement<T> element);

    public void addAllTo(Collection<T> col) throws UnmodifiableCollectionException;

}