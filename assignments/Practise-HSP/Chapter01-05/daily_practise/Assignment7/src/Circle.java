public class Circle extends Shapes {
    
    private double radius; // Private variable to store the radius of the circle
    private final double PI = 3.14; // Constant for the value of PI
    
    // Default constructor initializing the radius to 0.00
    public Circle() {
        radius = 0.00;
    }

    // Constructor with a parameter to set the radius of the circle
    public Circle(double radius) {
        this.radius = radius;
    }
    
    // Setter method for the radius
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    // Getter method for the radius
    public double getRadius() {
        return radius;
    }
    
    // Overridden method from Shapes to calculate the area of the circle
    public void calculateArea() {
        area = PI * (radius * radius);
    }
    
    // Overridden toString method to display the area of the circle
    public String toString() {
        return "Circle area is " + area;
    }
}
