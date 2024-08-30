/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

/**
 *
 * @author Tan Jee Schuan
 * @param <T>
 */

public class SortedArrayList<T extends Comparable<T>> extends ArrayList<T> {
    public SortedArrayList(){
        super();
    }
    
    public SortedArrayList(Object[] arr){
        super(arr);
    }
    
    @Override
    public boolean add(Object object) {
        if(isFull())
            expandArray();
        
        int i = findInsertionIndex((T)object);
        
        if( i < 0)
            return false;
            
        add(i, object);        
        return true;
    }
    
    @Override
    public boolean contains(Object object) {
        return binarySearch(array, 0, entries, (T)object) != -1;
    }
    
    @Override
    public int indexOf(Object object){
        return binarySearch(array, 0, entries, (T)object);
    }

    
    private int binarySearch(Object arr[], int start, int end, Object x){
        if(end >= start){
            int middle = start + (end - start) / 2 ;

            if(x.equals(arr[middle]))
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
    
    protected int findInsertionIndex(Object object){
        if(isEmpty())
            return 0;
            
        for(int i = 0; i < entries; i++){
            if(((T)object).compareTo((T)array[i]) < 0)
                return i;
        }
        return entries;
    }
}
