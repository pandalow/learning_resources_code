package ass8;

import java.util.*;

public abstract class Shapes implements ShapesRelate {
    public static void main(String[] args) {

        List<Shapes> arrayList = new ArrayList<>();
        arrayList.add(new Rectangle(10, 20));
        arrayList.add(new Circle(33));
        arrayList.add(new Rectangle(21, 9));
        arrayList.add(new Circle(22));

        Collections.sort(arrayList, (o1, o2) -> (int) (o1.getArea() - o2.getArea()));



        Collections.sort(arrayList, new Comparator<Shapes>() {
            @Override
            public int compare(Shapes o1, Shapes o2) {
                return (int) (o1.getArea() - o2.getArea());
            }
        });



//        arrayList.stream().sorted((o1,o2) -> o1.compareShapes(o2)).forEach(System.out::println);

//        ass8.Shapes shapes = largestShapes(arrayList);
//        System.out.println(shapes.toString());
    }

    public static Shapes largestShapes(List<Shapes> list) {
        Shapes largest = list.get(0);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareShapes(list.get(i + 1)) < 0) {
                largest = list.get(i + 1);
            }
        }
        return largest;
    }

    protected double area;

    public Shapes() {
        this.area = 0.0;
    }

    public double getArea() {
        return area;
    }

    public abstract void calculateArea();

    public int compareShapes(ShapesRelate shapeRelate) {
        Shapes shapes = (Shapes) shapeRelate;
        this.calculateArea();
        shapes.calculateArea();
        return (int) (this.area - shapes.getArea());
    }
}
