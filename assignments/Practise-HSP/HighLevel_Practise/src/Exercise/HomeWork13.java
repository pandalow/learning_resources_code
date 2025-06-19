package Exercise;

public class HomeWork13 {
    public static void main(String[] args) {
        new Circle1.PassObject().printAreas(new Circle1(),5);
    }
}
class Circle1{
    private double radius;

    public Circle1() {
        this.radius = 0.0;
    }

    public double findArea(){
        return Math.PI * Math.pow(radius,2);
    }

    static class PassObject{
        public void printAreas(Circle1 c, int times){
            System.out.println("Radius\t\tArea");
            for (int i = 1; i <= times; i++) {
                System.out.print(i+"\t\t\t");
                c.radius = i;
                System.out.println(c.findArea());
            }
        }
    }
}


