/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit3handson;

import java.util.Random;

/**
 *
 * @author Austyn
 */
public class RandomArray {
    static Random randGen = new Random();
    public static int[] loadArray(int numEntries) {
        int[] theArray = new int[numEntries];
        for (int i = 0; i < theArray.length; i++) {
            theArray[i] = randGen.nextInt(1000);
        }//End of for
        return theArray;
    }//End of loadArray
}
