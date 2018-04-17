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
public class SelectionSort {
    public static void selectionSort(int[] arr){  
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length - 1; i++) {  
            int index = i;  
            for (int j = i + 1; j < arr.length; j++){  
                if (arr[j] < arr[index]){  
                    index = j;//searching for lowest index  
                } //End of if
            } //End of inner for  
            int smallerNumber = arr[index];   
            arr[index] = arr[i];  
            arr[i] = smallerNumber;  
        } //End of outter for
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.print(executionTime);
    } //End of selectionSort
} //End of class
