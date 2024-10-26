package interfaces;

import java.util.Collection;
import java.util.Comparator;

public interface IList<E> extends Iterable<E>{
    E get(int index);

    void add(E element);
    void add(int index, E element);
    void addAll(Collection<? extends E> c);

    E remove(int index);
    boolean remove(Object o);
    void clear();

    boolean isEmpty();

    void sort(Comparator<? super E> c);


}
