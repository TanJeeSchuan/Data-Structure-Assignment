package adt;

import adt.interfaces.List;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author Tan Jee Schuan
 * @param <T>
 */

public class SortedArrayList<T extends Comparable> implements List<T>{
    private Comparator<T> comparator;
    
    protected T[] array;
    protected static final int DEFAULT_CAPACITY = 2;
    protected int maxSize;
    protected int entries = 0;
    
    public SortedArrayList(){
        array = (T[]) new Comparable[DEFAULT_CAPACITY];
        maxSize = DEFAULT_CAPACITY;
    }
    
    public SortedArrayList(Comparator<T> comparator){
        array = (T[]) new Comparable[DEFAULT_CAPACITY];
        maxSize = DEFAULT_CAPACITY;
        this.comparator = comparator;
    }
    
    public SortedArrayList(Object[] arr){
        while (maxSize < arr.length) {
            maxSize *= DEFAULT_CAPACITY;
        }
        array = (T[]) new Object[maxSize];
        System.arraycopy(arr, 0, array, 0, arr.length);
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < entries;
            }

            @Override
            public T next() {
                T data = (T)array[index];
                index++;
                return (T)data;
            }
        };
    }
    
    @Override
    public boolean add(T object) {
        if(isFull())
            expandArray();
        
        int i = findInsertionIndex((T)object);
        
        if( i < 0)
            return false;
            
        add(i, object);        
        return true;
    }
    
    private boolean add(int index, Object object) {
        if (isFull()) {
            expandArray();
        }

        if (index == entries) {
            array[entries] = (T) object;
            entries++;
        } else {
            makeSpace(index);
            array[index] = (T) object;
        }
        return true;
    }
    
    @Override
    public boolean contains(T object) {
        if(comparator == null)
            return binarySearch(array, 0, entries, (T)object) != -1;
        return comparatorBinarySearch(array, 0, entries, (T)object, 
                this.comparator) != -1;
    }
    
    @Override
    public int indexOf(T object){
        if(comparator == null)
            return binarySearch(array, 0, entries, (T)object);
        
        return comparatorBinarySearch(array, 0, entries, (T)object, 
                this.comparator);
    }
    
    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public boolean remove(T object) {
        int index = binarySearch(array,0,size(),object);
        
        if (index != -1){
            entries--;
            shiftArray(index);
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return entries;
    }
    
    public boolean isFull() {
        return (entries == maxSize);
    }
    
    public void clear(){
        for(int i = 0; i < entries; i++){
            array[i] = null;
        }
        entries = 0;
    }
    
    @Override
    public boolean isEmpty() {
        return (entries == 0);
    }

    @Override
    public Object[] toArray() {
        Object[] output = new Object[entries];
        System.arraycopy(array, 0, output, 0, entries);
        return output;
    }
    
    @Override
    public String toString() {
        String str = "[";
        for(int i = 0; i < entries; i++){
            str += (array[i]).toString();
            
            if(i < entries-1)
                str += ", ";
        }
        
        str += "]";
        return str;
    }
    
        protected void shiftArray(int empty) {
        for (int i = empty; i < entries; i++) {
            array[i] = array[i + 1];
        }
    }

    private void expandArray() {
        T[] newArr = (T[]) new Comparable[maxSize * DEFAULT_CAPACITY];

        for (int i = 0; i < maxSize; i++) {
            newArr[i] = (T) array[i];
        }

        maxSize *= DEFAULT_CAPACITY;
        array = newArr;
    }

    private void makeSpace(int index) {
        if (entries + 1 > maxSize) {
            expandArray();
        }

        for (int i = entries - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }

        entries++;
        array[index] = null;
    }
    
    private int binarySearch(Object arr[], int start, int end, Object x){
        if(end > start){
            int middle = start + (end - start) / 2 ;

            if(((T)arr[middle]).compareTo((T)x) == 0)
                return middle;

            //x at low
            if(((T)arr[middle]).compareTo((T)x) > 0)
                return binarySearch(arr, start, middle - 1, x);

            //x at higher part
            if(((T)arr[middle]).compareTo((T)x) < 0)
                return binarySearch(arr, middle + 1, end, x);
        }
        //not found
        return -1;
    }
    
    private int comparatorBinarySearch(Object arr[], int start, int end, 
            Object x, Comparator comparator){
        if(end >= start){
            int middle = start + (end - start) / 2 ;

            if(comparator.compare(x, arr[middle]) == 0)
                return middle;

            //x at low
            if(comparator.compare(arr[middle],(x)) > 0)
                return comparatorBinarySearch(arr, start, middle - 1, x, 
                        comparator);

            //x at higher part
            if(comparator.compare(arr[middle],(x)) < 0)
                return comparatorBinarySearch(arr, middle + 1, end, x, 
                        comparator);
        }
        //not found
        return -1;
    }

    private int findInsertionIndex(Object object){
        if(isEmpty())
            return 0;
            
        if(comparator == null){
            for(int i = 0; i < entries; i++){
                if(((T)object).compareTo((T)array[i]) < 0)
                    return i;
            }
            return entries;
        } else {
            for(int i = 0; i < entries; i++){
                if(comparator.compare((T)object, (T)array[i]) < 0)
                    return i;
            }
            return entries;
        }
    }
}
