package adt.interfaces;

/**
 *
 * @author Tan Jia Ning
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
