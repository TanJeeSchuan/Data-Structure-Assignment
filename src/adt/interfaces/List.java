/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt.interfaces;

/**
 *
 * @author Tan Jee Schuan
 */
public interface List<T> extends Iterable<T> {
    boolean add(T object);
    boolean contains(T object);
    boolean isEmpty();
    T get(int index);
    boolean remove(T object);
    int size();
    int indexOf(Object o);
    Object[] toArray();
}
