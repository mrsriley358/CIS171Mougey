/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylistshuffle;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Austyn
 */
public class ArrayListShuffle {
    
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        shuffle(integers);
    }
    
    public static <E> void shuffle(ArrayList<E> list) {
        System.out.println("The list before shuffle: " + list);
        Collections.shuffle(list);
        System.out.println("The list after shuffle: " + list);
        
    }
}
