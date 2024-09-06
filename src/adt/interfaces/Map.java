/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt.interfaces;

/**
 *
 * @author Cyborg
 */
public interface Map<K, V> {

    void add(K k, V v);

    V remove(K k);

    void put(K k, V v);

    V get(K k);

    boolean has(K k);

    int size();
    
    K getKey(int index);
}
