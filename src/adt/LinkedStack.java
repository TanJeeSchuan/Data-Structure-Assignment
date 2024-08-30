/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt;

import adt.interfaces.StackInterface;

/**
 *
 * @author Tan Jee Schuan
 * @param <T>
 */
public class LinkedStack<T> implements StackInterface<T>{
    private Node front;
    private int size;
    
    public LinkedStack(){
        front = null;
        size = 0;
    }
    
    @Override
    public void push(T item) {
        Node newNode = new Node(item, front);
        front = newNode;
        size++;
    }

    @Override
    public T pop() {
        T data = front.data;
        front = front.next;
        return data;
    }

    @Override
    public T peek() {
        return front.data;
    }
    
    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    
    private class Node{
        T data;
        Node next;
        public Node(T data){
            this.data = data;
        }
        public Node(T data, Node next){
            this.data = data;
            this.next = next;
        }
    }
}
