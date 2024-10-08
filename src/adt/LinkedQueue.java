package adt;

import java.util.Iterator;
import adt.interfaces.Queue;

/**
 *
 * @author Liau Xiao Xuan
 */
public class LinkedQueue<T> implements Queue<T>, Iterable<T>{
    protected Node firstNode;
    protected Node lastNode;
    protected int size;
    
    public LinkedQueue(){
        firstNode = null;
        lastNode = null;
        size = 0;
    }
    
    @Override
    public Iterator<T> iterator() {
        return getIterator();
    }

    @Override
    public Iterator<T> getIterator(){
        return new Iterator<T>(){
            private Node previousNode = null;
            private Node nextNode = firstNode ;
            private int nextIndex;
            
            @Override
            public boolean hasNext() {
                return nextIndex < size;
            }

            @Override
            public T next() {
                previousNode = nextNode;
                nextNode = nextNode.next;
                nextIndex++;
                return previousNode.data;
            }
        };
    }
    
    @Override
    public void enqueue(T newEntry){
        if(isEmpty()){
            firstNode = new Node(newEntry);
            lastNode = firstNode;
        }else{
            Node newNode = new Node(newEntry);
            lastNode.next = newNode;
            lastNode = newNode;
        }
        
        size++;
    }
    
    @Override
    public T dequeue(){
        T data = getFront();
        if(!isEmpty()){
            firstNode = firstNode.next;
            size--;
        }
        return data;
    }
    
    @Override
    public T getFront(){
        T data = null;
        if(!isEmpty()){
            data = firstNode.data;
        }
        return data;
    }
    
    @Override
    public boolean isEmpty(){
        return firstNode == null;
    }

    @Override
    public void clear(){
        firstNode = null;
        lastNode = null;
        size = 0;
    }
    
    public int getSize(){
        return size;
    }
    
    protected class Node {

        protected T data;
        protected Node next;

        protected Node(T data) {
            this.data = data;
            next = null;
        }

        protected Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    
    @Override
    public String toString(){
        String out = "";
        Node currentNode = firstNode;
        while(currentNode != null){
            out += currentNode.data.toString();
            currentNode = currentNode.next;
        }
        
        return out;
    }
}
