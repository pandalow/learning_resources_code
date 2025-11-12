package ass8;

public class Circle extends Shapes {

    private double radius;
    private final static double PI = 3.14;

    public Circle() {
        super();
    }

    public Circle(double radius) {
        super();
        this.radius = radius;
    }


    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void calculateArea() {
        super.area = PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "ass8.Circle{" +
                "radius=" + radius +
                ", area=" + area +
                '}';
    }
}
