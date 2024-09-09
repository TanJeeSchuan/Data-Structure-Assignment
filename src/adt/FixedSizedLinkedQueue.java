package adt;

/**
 *
 * @author Tan Jee Schuan
 */
public class FixedSizedLinkedQueue<T> extends LinkedQueue<T> {
    private int maxSize;
    
    public FixedSizedLinkedQueue(int maxSize){
        super();
        this.maxSize = maxSize;
    }
    
    @Override
    public void enqueue(T newEntry){
        if(size >= maxSize){
            dequeue();
            super.enqueue(newEntry);
        } else
            super.enqueue(newEntry);
    }
}
