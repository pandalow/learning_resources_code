package IOStream;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InputOutputExercise01 {
    @Test
    public void testFile() throws IOException {
        File file = new File("./myTemp/");
        if (!file.exists()) {
            System.out.println("no data");
            file.mkdir();
        }

        File file1 = new File("./myTemp/hello.txt");
        if (!file1.exists()) {
            System.out.println("no,file");
            if (file1.createNewFile()) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file1));
                writer.write("");
                writer.close();
            }
        }

    }
}
