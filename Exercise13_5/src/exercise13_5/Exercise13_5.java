/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise13_5;

/**
 *
 * @author Austyn
 */
public class Exercise13_5 {

    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(5,15);
        Rectangle rectangle2 = new Rectangle(10,25);
        
        Circle circle1 = new Circle(20);
        Circle circle2 = new Circle(30);
        
        System.out.println(GeometricObject.max(rectangle1, rectangle2));
        System.out.println(GeometricObject.max(circle1, circle2));
    }
    
}
