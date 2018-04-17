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
public class HeapSort {
    
    private static int[] a;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;
 
 
    public static void buildHeap(int []a) {
        n = a.length-1;
        for(int i=n/2; i>=0; i--){
            maxHeap(a,i);
        } //End of if
    } //End of buildHeap
 
   public static void maxHeap(int[] a, int i) { 
      left = 2*i;
      right = 2*i+1;
 
      if(left <= n && a[left] > a[i]){
         largest=left;
      } //End of if
      else {
         largest=i;
      } //End of else
 
      if(right <= n && a[right] > a[largest]) {
         largest=right;
      } //End of if
      if(largest!=i) {
         exchange(i, largest);
         maxHeap(a, largest);
      } //End of if
   } //End of maxHeap
 
   public static void exchange(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t; 
   } //End of exchange
 
   public static void sort(int[] arr) {
       long startTime = System.currentTimeMillis();
      a = arr;
      buildHeap(a);
      for(int i=n; i>0; i--) {
         exchange(0, i);
         n=n-1;
         maxHeap(a, 0);
      } //End of for
      long endTime = System.currentTimeMillis();
      long executionTime = endTime - startTime;
      System.out.print("\t\t" + executionTime);
   } //End of sort
} //End of class HeapSort
