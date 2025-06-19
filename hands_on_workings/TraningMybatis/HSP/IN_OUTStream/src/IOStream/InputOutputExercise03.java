package IOStream;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

import static java.lang.Integer.parseInt;

public class InputOutputExercise03 {

    private Dog01 dog01;
    @Test
    public void test1() throws IOException {
        File file = new File("./myTemp/dog.properties");
        Properties properties = new Properties();
        if (file.createNewFile()) {
            properties.setProperty("name", "tom");
            properties.setProperty("age", "5");
            properties.setProperty("color", "red");
            properties.store(new FileWriter(file), "");
        }
    }

    @Test
    public void test2() throws IOException {
        Properties properties = new Properties();

        properties.load(new FileReader("./myTemp/dog.properties"));
        dog01 = new Dog01(properties.getProperty("name"), parseInt(properties.getProperty("age")), properties.getProperty("color"));
//        PrintWriter out = new PrintWriter(System.out);
        System.out.println(dog01);
    }
    @Test
    public void test3() throws IOException{
        File file = new File("./myTemp/dog.dat");
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file));
        stream.writeObject(dog01);
        stream.close();

    }
}

class Dog01 implements Serializable{
    String name;
    int age;
    String color;

    public Dog01(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog01{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}