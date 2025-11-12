public class Rectangle extends Shapes {
    
    private double length; // Variable to store the length of the rectangle
    private double width; // Variable to store the width of the rectangle
    
    // Default constructor initializing length and width to 0.00
    public Rectangle() {
        this.length = 0.00;
        this.width = 0.00;
    }

    // Constructor with parameters to set the length and width of the rectangle
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    // Setter method for width
    public void setWidth(double width) {
        this.width = width;
    }
    
    // Getter method for width
    public double getWidth() {
        return width;
    }
    
    // Setter method for length
    public void setLength(double length) {
        this.length = length;
    }
    
    // Getter method for length
    public double getLength() {
        return length;
    }
    
    // Overridden toString method to display the area of the rectangle
    public String toString() {
        return "Rectangle Area is " + area;
    }
    
    // Method to calculate and update the area of the rectangle
    public void calculateArea() {
        area = width * length;
    }
}