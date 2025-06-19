package IOStream;

import java.io.*;

public class BufferedCopy {

    public static void main(String[] args) throws IOException {
        File srcPath = new File("./hola.markdown");
        File destPath = new File("./222.markdown");
        BufferedReader reader = new BufferedReader(new FileReader(srcPath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(destPath));
        String read;
        while ((read = reader.readLine()) != null) {
            writer.write(read);
            writer.newLine();
        }
        reader.close();
        writer.close();
    }
}
