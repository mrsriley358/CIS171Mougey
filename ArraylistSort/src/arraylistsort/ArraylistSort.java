/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylistsort;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Austyn
 */
public class ArraylistSort {
    
    public static void main(String[] args) {
        //Create arraylist of unorganized integers
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(24);
        integers.add(19);
        integers.add(13);
        integers.add(45);
        integers.add(32);
        
        //Create arraylist of unorganized strings
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Z");
        strings.add("G");
        strings.add("A");
        strings.add("M");
        strings.add("O");
        
        //Send the arraylists to the sort method
        System.out.println("A sorted list of integers");
        sort(integers);
        System.out.println("A sorted list of strings");
        sort(strings);
    }
    
    public static <E extends Comparable<E>> void sort (ArrayList<E> list) {
        //Sort the list that is sent to this method and print it
        Collections.sort(list);
        System.out.println(list);
    }
}
