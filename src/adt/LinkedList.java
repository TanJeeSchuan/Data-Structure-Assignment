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

public class LinkedList<T> implements List{
    protected Node head;
    protected Node tail;
    protected int size;
    
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
    
    public LinkedList(){
        head = null;
        tail = null;
        size = 0;
    }
    
    @Override
    public boolean add(Object object) {
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
    public boolean contains(Object object) {
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
    public Object get(int index) {
        int counter = 0;
        Node currentNode = head;
        while(counter < index){
            currentNode = currentNode.next;
            counter++;
        }
        
        return currentNode.data;
    }

    @Override
    public boolean remove(Object object) {
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
    public int indexOf(Object o) {
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
}
