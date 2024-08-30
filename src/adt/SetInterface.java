package adt;

public interface SetInterface<T>{
    public void add(T t);
    
    public void remove(T t);
    
    public boolean isEmpty();
    
    public boolean contains(T t);
    
    public int size();
    
    public T getValue(int index);
    
    public void clear();
}
