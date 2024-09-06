/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt.interfaces;

import java.util.Iterator;

/**
 *
 * @author LiauXiaoXuan
 */
public interface Queue<T> {

    public Iterator<T> getIterator();
    public void enqueue(T newEntry);
    public T dequeue();
    public T getFront();
    public boolean isEmpty();
    public void clear();
}
