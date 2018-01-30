/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inclasscalender;

import java.util.GregorianCalendar;
import java.util.Calendar;
/**
 *
 * @author Austyn
 */
public class InClassCalender {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GregorianCalendar gregCal = new GregorianCalendar(2015,2,1);
        
        System.out.println("Today: \t\t\t" + gregCal.get(GregorianCalendar.DAY_OF_MONTH));
    }
    
}
