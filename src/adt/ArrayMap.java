/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

import adt.interfaces.Map;

/**
 *
 * @author Tan Jia Ning
 * @param <K>
 * @param <V>
 */
public class ArrayMap<K, V> implements Map<K, V> {

    private static final int DEFAULT_CAPACITY = 2;
    int maxSize = 2;
    private Entry<K, V>[] array;
    private int size = 0;
    
    private static class Entry<K, V> {
        K key;
        V value;
        Entry(K k, V v) {
            this.key = k;
            this.value = v;
        }
        private Entry() {}
    }

    public ArrayMap() {
        array = new Entry[DEFAULT_CAPACITY];
        maxSize = DEFAULT_CAPACITY;
    }

    public boolean isEmpty() {
        return size==0;
    }
    
    @Override
    public void add(K k, V v) {
        if (isFull()) {
            expandArray();
        }
        Entry<K, V> newEntry = new Entry<>(k, v);
        array[size] = newEntry;
        size++;
    }

    @Override
    public V remove(K k) {
        V value = null;
        for (int i = 0; i < size; i++) {
            if (array[i].key.equals(k)) {
                value = array[i].value;
                array[i] = null;
                shiftedArray(i);
                size--;
                return value;
            }
        }
        return value;
    }

    @Override
    public void put(K k, V v) {
        for (int i = 0; i < size; i++) {
            if (array[i].key.equals(k)) {
                array[i].value = v;
                return;
            }
        }
    }

    public V get(K k) {
        for (int i = 0; i < size; i++) {
            if (array[i].key.equals(k)) {
                return array[i].value;
            }
        }
        return null;
    }

    @Override
    public boolean has(K k) {
        for (int i = 0; i < size; i++) {
            if (array[i].key.equals(k)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }
    
    @Override
    public K getKey(int index){
        return array[index].key;
    }

    protected void expandArray() {
        Entry[] newArr = new Entry[maxSize * DEFAULT_CAPACITY];

        for (int i = 0; i < maxSize; i++) {
            newArr[i] = array[i];
        }
        maxSize *= DEFAULT_CAPACITY;
        array = newArr;
    }

    public void shiftedArray(int index) {
        for (int i = index; i < size; i++) {
            array[i] = array[i+1];
        }
    }

    public boolean isFull() {
        return maxSize == size;
    }
}
