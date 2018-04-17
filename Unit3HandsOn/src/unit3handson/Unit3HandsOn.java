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
public class Unit3HandsOn {
    
    public static void main(String[] args) {
        
        System.out.println("Array Size\tSelection Sort\t\tRadix Sort\tBubble Sort\tMerge Sort\tQuick Sort\tHeap Sort");
        
        for (int i = 50000; i <= 300000; i += 50000) {
            int[] arr = RandomArray.loadArray(i);
            System.out.print(i + "\t\t");
            SelectionSort.selectionSort(arr);
            RadixSort.radixSort(arr);
            BubbleSort.bubbleSort(arr);
            long startTime = System.currentTimeMillis(); //I couldnt find a place to put the timer in the MergeSort class
            MergeSort.mergeSort(arr);                    //so I put it around the MergeSort here.
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            System.out.print("\t\t" + executionTime);
            QuickSort.quickSort(arr);
            HeapSort.sort(arr);
            System.out.println(""); //New line for the display
            //printArray(arr); //For testing
        } //End of for
    } //End of main
    
    public static void printArray(int[] arr) { //For testing
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        } //End of for
        System.out.println();
    } //End of printArray
} //End of class
