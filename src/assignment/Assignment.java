/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment;

import adt.SortedArrayList;
import boundary.MainInterface;
import entity.CharityCause;
import entity.DonationManagement;
import entity.Donor;

/**
 *
 * @author Tan Jee Schuan
 */
public class Assignment {
    
    public static void main(String[] args) {
        DonationManagement don = new DonationManagement();
        
        Donor donor1 = new Donor("Alice", "A@a.aa");
        CharityCause charityCause = new CharityCause("ABC");
        don.addDonation(donor1, charityCause, 0);
        
        System.out.println(don.getRecentDonors());
        
        MainInterface ui = new MainInterface();
        while(!ui.isEnd()){
            ui.startUI();
        }
    }
    
//    public static void main(String[] args) {
////       LinkedQueue<Integer> arr = new FixedSizedLinkedQueue<>(5); 
//       
//        SortedArrayList<Integer> arr = new SortedArrayList();
//
//       assert arr.isEmpty() == true: "Is not empty";
////        SortedArrayList<Integer> arr = new SortedArrayList(new Comparator<Integer>(){
////            @Override
////            public int compare(Integer o1, Integer o2) {
////                    return Integer.compare(o1, o2);
////            }
////        });
//
////        LinkedSet<Integer> arr = new LinkedSet();
//        arr.add(1);
//        arr.add(25);
//        arr.add(23);
//        arr.add(345);
//        arr.add(73);
//        arr.add(18);
//        arr.add(92);
//        arr.add(45);
//        arr.add(61);
//        arr.add(29);
//        arr.add(87);
//        arr.add(34);
//        arr.add(56);
//        arr.add(78);
//        arr.add(12);
//        arr.add(64);
//        arr.add(91);
//        arr.add(33);
//        arr.add(50);
//        arr.add(47);
//        arr.add(82);
//        arr.add(95);
//        arr.add(22);
//        arr.add(70);
//        arr.add(39);
//        arr.add(54);
//        arr.add(89);
//        arr.add(41);
//        arr.add(26);
//        arr.add(66);
//        arr.add(19);
//        arr.add(80);
//        arr.add(11);
//        arr.add(98);
//        arr.add(27);
//        arr.add(77);
//        arr.add(63);
//        
//                
//        for(Object i : arr.toArray()){
//            System.out.println(i);
//        }
//        
////        for(int i = 0; i < arr.size(); i++){
////            System.out.println(arr.get(i));
////        }
////        
//        System.out.println("\n");
//        
//        System.out.println(arr.indexOf(63));
//        
//        
////        assert arr.getSize()== 37 : "Wrong Size";
//        
////        System.out.println(arr.getValue(2));
////        System.out.println(arr.dequeue() + "\n\n");
//        
////        for(Integer i: arr){
////            System.out.println(i);
////        }
//        
////        arr.remove(18);
////        
////        System.out.println(arr.get(5));
////        
////        System.out.println(arr.contains(18));
////        System.out.println(arr.contains(63));
//        
////        arr.add(1);
////        assert !arr.isEmpty() : "List should not be empty after adding an element";
////        assert arr.size() == 38 : "List size should be 1 after adding one element";
////        assert 1 == (arr.get(37)) : "First element should be 'Element1'";
//
////        arr.remove(arr.get(1));
//        
////        for (int i = 0; i < arr.size() ; i++){
////            System.out.println(arr.get(i));
////        }
////        
////        System.out.println("-----------------------------------");
////
////        arr.add(7);
////        
//////        arr.add(1, 2);
////        
////        for (int i = 0; i < arr.size() ; i++){
////            System.out.println(arr.get(i));
////        }
//    }
}
