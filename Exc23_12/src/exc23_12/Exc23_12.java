/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exc23_12;

/**
 *
 * @author Austyn
 */
public class Exc23_12 {
    
    public static void main(String[] args) {
        int[] arr = RandomArray.loadArray(35);
        System.out.print("Initial Array : ");
        printArray(arr);
        radixSort(arr);
    }
    public static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void radixSort(int arr[]) {
        //Finding maximum number to count the number of digits
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++)
            max = Math.max(max, arr[i]);
        
        System.out.println("MAX: " + max);

        int p = 1;
        int pass = 1;

        while(max / p > 0) {
            arr = countingSort(arr, arr.length, p);
            System.out.print("After pass " + pass + "  : ");
            printArray(arr);
            pass++;
            p *= 10;
        }
    }
    public static int[] countingSort(int arr[], int N, int p) {
        int output[] = new int[N];
        int count[] = new int[10]; //keeping count of the digit in the correct position

        for(int i = 0; i < N; i++) {
            count[(arr[i] / p) % 10]++;
        }

        //Applying counting sort so now the array contains actual position of the digits
        for(int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
        //Starting from N-1 helps to keep digits in order
        for(int i = N - 1; i >= 0; i--) {
            output[count[(arr[i] / p) % 10] - 1] = arr[i];
            count[(arr[i] / p) % 10]--;
        }
        return output;
    }
}
