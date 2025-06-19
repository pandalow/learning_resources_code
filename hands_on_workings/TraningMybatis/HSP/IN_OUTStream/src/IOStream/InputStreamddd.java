package IOStream;

import org.junit.Test;

import java.io.*;

public class InputStreamddd {
    @Test
    public void InS() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader
                        (new FileInputStream("./1MF1.pdf"), "gbk"));

        BufferedWriter writer = new BufferedWriter(new FileWriter("./co.pdf"));
        String read;
        while((read = reader.readLine())!=null){
            writer.write(read);
            writer.newLine();

        }
        writer.close();
        reader.close();
    }
}
