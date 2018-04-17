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
public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            //Merge sort the fist half
            int[] firstHalf = new int[arr.length / 2];
            mergeSort(firstHalf);
            
            //Merge sort the second half
            int secondHalfLength = arr.length - arr.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(arr, arr.length / 2, secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);
            
            //Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, arr);
        } //End of if
    } //End of mergeSort
    
    //Merge two sorted lists
    public static void merge(int[] arr1, int[] arr2, int[] temp) {
        int current1 = 0; //Current index in arr1
        int current2 = 0; //Current index in arr2
        int current3 = 0; //Current index in temp
        
        while (current1 < arr1.length && current2 < arr2.length) {
            if (arr1[current1] < arr2[current2])
                temp[current3++] = arr1[current1++];
            else
                temp[current3++] = arr2[current1++];
        } //End of while
        
        while (current1 < arr1.length)
            temp[current3++] = arr1[current1++];
        
        while (current2 < arr2.length)
            temp[current3++] = arr2[current2++];
    } //End of merge
} //End of Class