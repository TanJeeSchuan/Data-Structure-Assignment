package adt.interfaces;

import java.util.Iterator;

/**
 *
 * @author LiauXiaoXuan
 */
public interface Queue<T> {

    public Iterator<T> getIterator();
    public void enqueue(T newEntry);
    public T dequeue();
    public T getFront();
    public boolean isEmpty();
    public void clear();
}
