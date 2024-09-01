package adt;

import adt.interfaces.SetInterface;
import java.util.Iterator;

public class LinkedSet<T> implements SetInterface<T>, Iterable<T> {

    private Node firstNode;
    private Node lastNode;
    private int size;

    @Override
    public Iterator<T> iterator() {
        return new Iterator(){
            @Override
            public boolean hasNext() {
                return firstNode.next != null;
            }

            @Override
            public Object next() {
                Node node = firstNode;
                firstNode = firstNode.next;
                return node.value;  
            }
        };
    }

    private class Node {

        private T value;
        private Node next;

        private Node(T value) {
            this.value = value;
            this.next = null;
        }

        private Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public LinkedSet() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    @Override
    public void add(T t) {

        Node newNode = new Node(t);

        if (isEmpty()) { // if the set is empty, straightly add the element into the set
            firstNode = newNode;
            lastNode = firstNode;
            size++;
        } else if (!contains(t)) { // check the element in the set, return true if the element is not exist
            lastNode.next = newNode;
            lastNode = newNode;
            size++;
        }
    }

    @Override
    public void remove(T t) {
        if (isEmpty()) {
            return;
        }
        
        if (firstNode.value.equals(t)) {
            firstNode = firstNode.next;
            size--;
        }

        Node currentNode = firstNode;

        while (currentNode.next != null) {
            if (currentNode.next.value.equals(t)) {
                currentNode.next = currentNode.next.next;
                size--;
            } else {
                currentNode = currentNode.next;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return firstNode == null;
    }

    @Override
    public boolean contains(T t) {
        Node currentNode = firstNode;

        while (currentNode != null) {
            if (currentNode.value.equals(t)) {
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }

    @Override
    public int size() {
        if (size > 0) {
            return size;
        }
        return 0;
    }
    
    @Override
    public T getValue(int index){
        Node currentNode = firstNode;
        for(int i = 0; i< index; i++){
            currentNode = currentNode.next;
        }
        return currentNode.value;
    }

    @Override
    public void clear() {
        firstNode = null;
        size = 0;
    }
}
