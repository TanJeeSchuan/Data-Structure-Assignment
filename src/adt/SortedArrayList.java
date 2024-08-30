/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

import java.util.Comparator;

/**
 *
 * @author Tan Jee Schuan
 * @param <T>
 */

public class SortedArrayList<T> extends ArrayList<T> {
    Comparator<T> comparator;
    
    public SortedArrayList(Comparator<T> comparator){
        super();
        this.comparator = comparator;
    }
    
    @Override
    public boolean add(Object object) {
        if(isFull())
            expandArray();
        
        int i = findInsertionIndex(object);
        
        if( i < 0)
            return false;
            
        add(i, object);        
        return true;
    }
    
    @Override
    public boolean contains(Object object) {
        return binarySearch(array, 0, entries, (T)object, comparator) != -1;
    }
    
    @Override
    public int indexOf(Object object){
        return binarySearch(array, 0, entries, (T)object, comparator);
    }

    
    private static int binarySearch(Object arr[], int start, int end, Object x, Comparator comparator){
        if(start >= end){
            int middle = start + (start + end) / 2 ;

            if(x.equals(arr[middle]))
                return middle;

            //x at low
            if(comparator.compare(arr[middle], x) > 0)
                return binarySearch(arr, start, middle - 1, x, comparator);

            //x at higher part
            if(comparator.compare(arr[middle], x) < 0)
                return binarySearch(arr, middle + 1, end, x, comparator);
        }
        //not found
        return -1;
    }
    
    protected int findInsertionIndex(Object object){
        if(isEmpty())
            return 0;
            
        for(int i = 0; i < entries; i++){
            if(comparator.compare((T)object, array[i]) < 0)
                return i;
        }
        return entries;
    }
}
