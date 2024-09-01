/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

/**
 *
 * @author Tan Jee Schuan
 * @param <E>
 */
public class ArraySet<E>{
    
    private static final int DEAFULT_CAPACITY = 2;
    private int maxSize;
    private int currentSize;
    private E array[];

    public ArraySet() {
        this.array = (E[])(new Object[DEAFULT_CAPACITY]);
        this.maxSize = DEAFULT_CAPACITY;
        currentSize = 0;
    }
    
    public void add(Object object) {
        if(isFull())
            array[0] = (E)object;
    }
    
    public void remove(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    public boolean isEmpty() {
        return currentSize == 0;
    }

    
    public boolean contains(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    public int size() {
        return currentSize;
    }
    
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private boolean isFull() {
        return currentSize==maxSize;
    }
    
}
