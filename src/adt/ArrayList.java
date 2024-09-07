package adt;

import adt.interfaces.List;
import java.util.Iterator;

/*
Author: Tan You Zhen
 * @param <T>
 */
public class ArrayList<T> implements List<T>{

    protected T[] array;
    protected static final int DEFAULT_CAPACITY = 2;
    protected int maxSize;
    protected int entries = 0;

    public ArrayList() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        maxSize = DEFAULT_CAPACITY;
    }

    public ArrayList(Object[] arr) {
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
    public boolean add(Object object) {
        if (isFull()) {
            expandArray();
        }

        array[entries] = (T) object;
        entries++;

        return true;
    }

    public boolean add(int index, Object object) {
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
    public T get(int index) throws ArrayIndexOutOfBoundsException {
        if (index > entries) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < entries; i++) {
            if (object.equals(array[i])) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public boolean remove(Object object) {
        for (int i = 0; i < entries; i++) {
            if (array[i].equals(object)) {
                entries--;
                shiftArray(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public int size() {
        return entries;
    }

    protected void shiftArray(int empty) {
        for (int i = empty; i < entries; i++) {
            array[i] = array[i + 1];
        }
    }

    protected void expandArray() {
        T[] newArr = (T[]) new Object[maxSize * DEFAULT_CAPACITY];

        for (int i = 0; i < maxSize; i++) {
            newArr[i] = (T) array[i];
        }

        maxSize *= DEFAULT_CAPACITY;
        array = newArr;
    }

    protected void makeSpace(int index) {
        if (entries + 1 > maxSize) {
            expandArray();
        }

        for (int i = entries - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }

        entries++;
        array[index] = null;
    }

    @Override
    public boolean contains(Object anEntry) {
        boolean found = false;
        for (int index = 0; !found && (index < entries); index++) {
            if (anEntry.equals(array[index])) {
                found = true;
            }
        }
        return found;
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
}
