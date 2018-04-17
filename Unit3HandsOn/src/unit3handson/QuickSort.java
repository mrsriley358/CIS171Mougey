/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit3handson;

public class QuickSort {
    public static void quickSort(int[] arr) {
        long startTime = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.print("\t\t" + executionTime);
    } //End of qickSort
    
    public static void quickSort(int[] arr, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(arr, first, last);
            if (pivotIndex - first <= last - (pivotIndex + 1)) {
                quickSort(arr, first, pivotIndex);
                first = pivotIndex + 1;
            } //End of inner if
            else {
                quickSort(arr, pivotIndex + 1, last);
                last = pivotIndex;
            } //End of else
            //quickSort(arr, first, pivotIndex - 1);  ***I replaced these two lines with the if and else lines above to fix***
            //quickSort(arr, pivotIndex + 1, last);   ***a stackoverflow error that I was receiving***
        } //End of if
    } //End of method quickSort
    
    public static int partition(int[] arr, int first, int last) {
        int pivot = arr[first];
        int low = first + 1;
        int high = last;
        
        while (high > low) {
            //Search forward from left
            while (low <= high && arr[low] <= pivot)
                low++;
            //Search backward from right
            while (low <= high && arr[high] > pivot)
                high--;
            //Swap two elements in the list
            if (high > low) {
                int temp = arr[high];
                arr[high] = arr[low];
                arr[low] = temp;
            } //End of if
        } //End of while
        
        while (high > first && arr[high] >= pivot)
            high--;
        //Swap pivot with arr[high
        if(pivot > arr[high]) {
            arr[first] = arr[high];
            arr[high] = pivot;
            return high;
        } //End of if
        else {
            return first;
        } //End of else
    } //End of partition 
} //End of class
