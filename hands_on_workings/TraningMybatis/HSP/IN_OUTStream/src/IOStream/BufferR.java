package IOStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferR {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =
                new BufferedReader(new FileReader(new String("./1MF1.pdf")));
        String read = "";
        while ((read = bufferedReader.readLine()) != null) {
            System.out.println(read);

            bufferedReader.close();
        }
    }
}
