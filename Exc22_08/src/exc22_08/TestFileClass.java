/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exc22_08;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Austyn
 */
public class TestFileClass {
    public final static int NUMBERONLINE = 10;
    public static void printFile() {
        long count = 0;
        try (
                DataInputStream dis = new DataInputStream(new FileInputStream("PrimeNumbers.dat"));
                ) {
            long total = 0;
            System.out.println("PrintFile is printing: \n");
            while (dis.available() > 0) {
                long temp = dis.readLong();
                total += temp;
                count++;
                if ((count % NUMBERONLINE )== 0)
                        System.out.print("\n" + temp + " ");
                else
                    System.out.print(temp + " ");
            }
            
            System.out.println("\nCount is " + count);
            System.out.println("\nTotal is " + total);
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
