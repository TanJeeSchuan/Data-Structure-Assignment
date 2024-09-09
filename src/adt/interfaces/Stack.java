package adt.interfaces;

/**
 *
 * @author Tan Jee Schuan
 */
public interface Stack<T> {
    public void push (T item);
    public T pop();
    public T peek();
    public boolean isEmpty();
}
