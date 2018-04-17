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
public class RadixSort {
    public static void radixSort(int arr[]) {
        //Finding maximum number to count the number of digits
        long startTime = System.currentTimeMillis();
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++)
            max = Math.max(max, arr[i]);

        int p = 1;

        while(max / p > 0) {
            arr = countingSort(arr, arr.length, p);
            p *= 10;
        } //End of while
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.print("\t\t\t" + executionTime);
    } //End of radixSort
    
    public static int[] countingSort(int arr[], int N, int p) {
        int output[] = new int[N];
        int count[] = new int[10]; //keeping count of the digit in the correct position

        for(int i = 0; i < N; i++) {
            count[(arr[i] / p) % 10]++;
        } //End of for

        //Applying counting sort so now the array contains actual position of the digits
        for(int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        } //End of for
        
        //Starting from N-1 helps to keep digits in order
        for(int i = N - 1; i >= 0; i--) {
            output[count[(arr[i] / p) % 10] - 1] = arr[i];
            count[(arr[i] / p) % 10]--;
        } //End of for
        return output;
    } //End of countingSort
} //End of class
