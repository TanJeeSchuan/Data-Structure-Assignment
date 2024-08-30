/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment;

import adt.FixedSizedLinkedQueue;
import adt.LinkedQueue;
import java.util.Comparator;
/**
 *
 * @author Tan Jee Schuan
 */
public class Assignment {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       LinkedQueue<Integer> arr = new FixedSizedLinkedQueue<>(5); 
       
       assert arr.isEmpty() == true: "Is not empty";
//        SortedArrayList<Integer> arr = new SortedArrayList(new Comparator<Integer>(){
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                    return Integer.compare(o1, o2);
//            }
//        });

//        LinkedSet<Integer> arr = new LinkedSet();
        arr.enqueue(1);
        arr.enqueue(25);
        arr.enqueue(23);
        arr.enqueue(345);
        arr.enqueue(73);
        arr.enqueue(18);
        arr.enqueue(92);
        arr.enqueue(45);
        arr.enqueue(61);
        arr.enqueue(29);
        arr.enqueue(87);
        arr.enqueue(34);
        arr.enqueue(56);
        arr.enqueue(78);
        arr.enqueue(12);
        arr.enqueue(64);
        arr.enqueue(91);
        arr.enqueue(33);
        arr.enqueue(50);
        arr.enqueue(47);
        arr.enqueue(82);
        arr.enqueue(95);
        arr.enqueue(22);
        arr.enqueue(70);
        arr.enqueue(39);
        arr.enqueue(54);
        arr.enqueue(89);
        arr.enqueue(41);
        arr.enqueue(26);
        arr.enqueue(66);
        arr.enqueue(19);
        arr.enqueue(80);
        arr.enqueue(11);
        arr.enqueue(98);
        arr.enqueue(27);
        arr.enqueue(77);
        arr.enqueue(63);
        
        
//        assert arr.getSize()== 37 : "Wrong Size";
        
//        System.out.println(arr.getValue(2));
//        System.out.println(arr.dequeue() + "\n\n");
        
        for(Integer i: arr){
            System.out.println(i);
        }
        
//        arr.remove(18);
//        
//        System.out.println(arr.get(5));
//        
//        System.out.println(arr.contains(18));
//        System.out.println(arr.contains(92));
        
//        arr.add(1);
//        assert !arr.isEmpty() : "List should not be empty after adding an element";
//        assert arr.size() == 38 : "List size should be 1 after adding one element";
//        assert 1 == (arr.get(37)) : "First element should be 'Element1'";

//        arr.remove(arr.get(1));
        
//        for (int i = 0; i < arr.size() ; i++){
//            System.out.println(arr.get(i));
//        }
//        
//        System.out.println("-----------------------------------");
//
//        arr.add(7);
//        
////        arr.add(1, 2);
//        
//        for (int i = 0; i < arr.size() ; i++){
//            System.out.println(arr.get(i));
//        }
    }
}
