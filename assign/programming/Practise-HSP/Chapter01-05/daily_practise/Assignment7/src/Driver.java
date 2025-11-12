import java.util.List;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Driver implements Serializable {

    public static void main(String[] args) {
        // Create a list to store shape objects
        List<Shapes> mylist = new ArrayList<>();

        // Create a circle with radius 2.00 and add to the list
        Circle circle = new Circle(2.00);
        mylist.add(circle);

        // Create two rectangles with different dimensions and add to the list
        Rectangle rectangle01 = new Rectangle(2.11, 3.11);
        mylist.add(rectangle01);

        Rectangle rectangle02 = new Rectangle(1.24, 4.21);
        mylist.add(rectangle02);

        // Calculate the area for each shape in the list
        for (int i = 0; i < mylist.size(); i++) {
            mylist.get(i).calculateArea();
        }

        // Serialize the list of shapes to a file named 'Shape.dat'
        try {
            FileOutputStream fileStream = new FileOutputStream("Shape.dat");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(mylist);
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Deserialize the 'Shape.dat' file to retrieve the list of shapes
        try {
            FileInputStream fileStream = new FileInputStream("Shape.dat");
            ObjectInputStream os = new ObjectInputStream(fileStream);
            List<Shapes> list = (List<Shapes>) os.readObject();

            // Print out the details of each shape in the deserialized list
            for (Shapes shape : list) {
                System.out.println(shape.toString());
            }
            os.close();

            // Print the largest shape in the list
            System.out.println("The biggest one is " + largestShape(list).toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Method to find the largest shape in a given list of shapes
    public static Shapes largestShape(List<Shapes> list) {
        Shapes largest = list.get(0);

        // Iterate through the list to find the shape with the largest area
        for (Shapes shape : list) {
            if (largest.compareShapes(shape) < 0) {
                largest = shape;
            }
        }
        return largest;
    }
}