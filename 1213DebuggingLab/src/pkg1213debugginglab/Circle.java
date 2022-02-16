package pkg1213debugginglab;
/*
 * ITSC 1213 Module 2
 * The Circle class represents a circle with a radius and color.
 */
/**
 * This class describes a circle with a given radius and color.
 *
 * @author Tyler Foeller
 * @version Spring '22
 */
public class Circle {  // Save as "Circle.java"
    // private instance variable, not accessible from outside this class
    private double radius;
    private String color;
    private double area;
    
    // The default constructor with no argument.
    // It sets the radius and color to their default value.
     /**
     * Constructs a Circle with default radius and default color
     */
    public Circle() {
        radius = 1.0;
        color = "red";
    }
    // 2nd constructor with given radius and color
    /**
     * Constructs a Circle with a given radius and color
     *
     * @param r the radius of the Circle
     * @param clr the color of the Circle
     */
    public Circle(double r, String clr) {
        radius = r;
        color = clr;
    }
    // A public method for retrieving the radius
    /**
     *
     * @return Returns a double value of the radius of the Circle
     */
    public double getRadius() {
        return radius;
    }
    // A public method for retrieving the area of circle
     /**
     *
     * @return Returns a double value of the area of the Circle
     */
    public double getArea() {
        calculateArea();
        return area;
    }
    // A private method for computing the area of circle
     /**
     *
     * Computes the area of the circle
     */
    private void calculateArea() {
        area = radius * radius * Math.PI;
    }
}
