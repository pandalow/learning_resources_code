package Exercise;


class Circle {
    private double radius;

    private final static double PI = 3.14;

    public void preimeter(){
        System.out.println(2 * PI * radius);
    }
    public void area(){
        System.out.println(PI * Math.pow(radius, 2));
    }
}
