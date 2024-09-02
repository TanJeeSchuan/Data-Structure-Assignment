package adt.interfaces;

import java.util.Iterator;

public interface SetInterface<T> extends Iterable{
    public Iterator<T> iterator();
    
    public void add(T t);
    
    public void remove(T t);
    
    public boolean isEmpty();
    
    public boolean contains(T t);
    
    public int size();
    
    public T getValue(int index);
    
    public void clear();
}
