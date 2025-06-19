import java.io.Serializable;

public abstract class Shapes implements ShapesRelate, Serializable {

    protected double area; // Protected variable to store the area of the shape

    // Default constructor initializing the area to 0.00
    public Shapes() {
        this.area = 0.00;
    }

    // Method to return the area of the shape
    public double getArea() {
        return area;
    }

    // Abstract method to calculate the area, to be implemented in subclasses
    abstract void calculateArea();

    // Method to compare this shape with another shape based on their areas
    public int compareShapes(ShapesRelate shapesRelate) {
        Shapes shape = (Shapes) shapesRelate;

        // Returning 1 if this shape's area is greater, 0 if equal, and -1 if lesser
        if (this.area > shape.getArea()) {
            return 1;
        } else if (this.area == shape.getArea()) {
            return 0;
        } else {
            return -1;
        }
    }

}