package IOStream;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputOutputExercise02 {
    @Test
    public void readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("./myTemp/hello.txt"));
        String read;
        int cont = 1;
        while ((read = reader.readLine()) != null) {
            System.out.println("[" + cont++ + "]" + read);
        }
    }
}
