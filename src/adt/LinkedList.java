/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

import adt.interfaces.List;
import java.util.Iterator;

/**
 *
 * @author Tan Jee Schuan
 * @param <T>
 */

public class LinkedList<T> implements List<T>{
    protected Node head;
    protected Node tail;
    protected int size = 0;

    public LinkedList(){
        head = null;
        tail = null;
        size = 0;
    }
    
    public LinkedList(T[] arr){
        this();
        for(T o: arr){
            this.add(o);
        }
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator(){
            private int index = 0;
            private Node currentNode = head;
            
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Object next() {
                Node prevNode = currentNode;
                currentNode = currentNode.next;
                index++;
                return prevNode.data;
            }
        };
    }
    
    class Node{
        public T data;
        public Node next;
        
        public Node(T data, Node next){
            this.data = data;
            this.next = next;
        }
        
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    @Override
    public boolean add(T object) {
        if(isEmpty()){
            head = new Node((T)object);
            tail = head;
            size++;
        } else {
            tail.next = new Node((T)object);
            tail = tail.next;
            size++;
        }
        return true;
    }

    @Override
    public boolean contains(T object) {
        if(isEmpty())
            return false;
        
        Node currentNode = head;
        while(currentNode.next != null){
            if(object.equals(currentNode.data))
                return true;
            
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public T get(int index) {
        int counter = 0;
        Node currentNode = head;
        while(counter < index){
            currentNode = currentNode.next;
            counter++;
        }
        
        return currentNode.data;
    }

    @Override
    public boolean remove(T object) {
        int counter = 0;
        if(head.data.equals(object)){
            head = null;
            return true;
        }
        
        Node currentNode = head;
        while(currentNode.next != null){
            if(object.equals(currentNode.next.data)){
                currentNode.next = currentNode.next.next;
                size--;
                return true;
            }
            
            currentNode = currentNode.next;
            counter++;
        }
        
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(T o) {
        if(isEmpty())
            return -1;
        
        int counter = 0;
        Node currentNode = head;
        while(currentNode.next != null){
            if(o.equals(currentNode.data))
                return counter;
            
            currentNode = currentNode.next;
            counter++;
        }    
        
        return -1;
    }
    
    public Node getNode(int index) {
        int counter = 0;
        
        if(index > size)
            return null;
        
        Node currentNode = head;
        while(counter < index){
            currentNode = currentNode.next;
            counter++;
        }
        
        return currentNode;
    }
    
    @Override
    public Object[] toArray(){
        int expansionFactor = 2;
        int count = 0;
        T[] arr = (T[])new Object[expansionFactor];
        
        if(isEmpty())
            return null;
                
        Node currentNode = head;
        while(currentNode.next != null){
            if(count >= arr.length)
                arr = expandArray(arr, expansionFactor);
            
            arr[count] = currentNode.data;
            count++;
            
            currentNode = currentNode.next;
        }
        
        return arr;
    }
    
    private T[] expandArray(T[] array, int expansionFactor){
        int newSize = array.length * expansionFactor;
        T[] newArr = (T[])new Object[newSize];
        System.arraycopy(array, 0, newArr, 0, array.length);
        return newArr;
    }
}
