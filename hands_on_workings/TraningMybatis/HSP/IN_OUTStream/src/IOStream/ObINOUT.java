package IOStream;

import org.junit.Test;

import java.io.*;

public class ObINOUT {
    @Test
    public void serial() throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("./dog.dat"));

//        outputStream.writeObject(new Dog01("love", 1));
        outputStream.writeInt(1);
        outputStream.writeChar('c');
        outputStream.writeBoolean(true);
        outputStream.close();
    }

    @Test
    public void deserial() throws  IOException{
        ObjectInputStream inputSteam = new ObjectInputStream(new FileInputStream("./dog.dat"));
        int readLen = 0;
        while((readLen = inputSteam.read())!=-1){
            System.out.println(readLen);
        }
    }
}

class Dog implements Serializable {
    String name;
    int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}