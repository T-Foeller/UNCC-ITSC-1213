/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg1213debugginglab;

import java.awt.Rectangle;

/**
 *
 * @author Tyler Foeller
 */
public class RetangleTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Part B
        
        //Initial Rectangles
        Rectangle box1 = new Rectangle(10, 10, 40, 30);
        Rectangle box2 = new Rectangle(100,50);
        
        System.out.println("box1: " + box1);
        System.out.println("box2: " + box2);
        
        //Move box1 to point (20,20)
        System.out.println("Moving box1 to point (20,20)...");
        box1.setLocation(20,20);
        
        //Change box2's width to 50 and height to 30
        System.out.println("Changing box2 size to 50 x 30...");
        box2.setSize(50,30);
        
        System.out.println("box1: " + box1);
        System.out.println("box2: " + box2);
        
        //Make a new rectangle that is the intersection between box1 and box 2
        System.out.println("Making an intersection Rectangle...");
        Rectangle box3 = box1.intersection(box2);
        
        //Variable that calculates the area of the intersection
        System.out.println("Calculating area of intersection Rectangle...");
        double areaOfBox3 = box3.getHeight() * box3.getWidth();
        
        System.out.println("Area of intersection between box1 and box2: " + areaOfBox3);
        System.out.println("box3: " + box3);
    }
}
        
        
   