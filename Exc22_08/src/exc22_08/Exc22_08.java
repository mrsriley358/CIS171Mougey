/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exc22_08;

import java.io.RandomAccessFile;

/**
 *
 * @author Austyn
 */
public class Exc22_08 {
    final static int ARRAY_SIZE = 10000;
    
    public static void main(String[] args) throws Exception {
        //TestFileClass.printFile();
      
        final long N = 1000000;
        long[] primeNumbers = new long[ARRAY_SIZE];
        
        int squareRoot = 1;
        long number; //The number we are testing for primeness
        
        //Check our file
        //Establish our number
        //Are we starting fresh, or do we have a file
        RandomAccessFile inout = new RandomAccessFile("PrimeNumbers.dat", "rw");
        if (inout.length() == 0) {
            number = 1;
        }
        else {
            inout.seek(inout.length() - 8); //Last long in file
            number = inout.readLong(); //Read the last long in file
        }
        
        newNumber:while (number <= N) {
            //Check to see if number++ is prime
            number++;
            
            inout.seek(0);
            
            if (squareRoot * squareRoot < number) {
                squareRoot++;
            }
            
            while (inout.getFilePointer() < inout.length()) {
                int size = readNextBatch(primeNumbers, inout);
                
                for (int k = 0; k < size && primeNumbers[k] <= squareRoot; k++) {
                    if (number % primeNumbers[k] == 0) { //this number is not prime
                        continue newNumber;
                    }
                }
            }
            
            //Append a new prime number to the end of the file
            inout.seek(inout.length());
            inout.writeLong(number);
        }
    }
    
    public static int readNextBatch(long[] primeNumbers, RandomAccessFile inout) {
        int size = 0;
        try {
                while (inout.getFilePointer() < inout.length() && size < ARRAY_SIZE) {
                    primeNumbers[size++] = inout.readLong();
                }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return size;
    }
}
