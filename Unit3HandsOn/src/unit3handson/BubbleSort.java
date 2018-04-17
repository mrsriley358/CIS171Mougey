/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit3handson;

/**
 *
 * @author Austyn
 */
public class BubbleSort {
    static void bubbleSort(int[] arr) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } //End of if
            } //End of inner for
        } //End of outer for
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.print("\t\t" + executionTime);
    } //End of bubbleSort
} //End of class
