package adt.interfaces;

/**
 *
 * @author Tan You Zhen
 */
public interface List<T> extends Iterable<T> {
    boolean add(T object);
    boolean contains(T object);
    boolean isEmpty();
    T get(int index);
    boolean remove(T object);
    int size();
    int indexOf(T o);
    Object[] toArray();
}
