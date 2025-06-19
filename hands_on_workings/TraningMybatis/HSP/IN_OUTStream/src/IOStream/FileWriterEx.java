package IOStream;

import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {
    @Test
    public void fileRe() {
        try {
            FileReader fileReader = new FileReader("1MF1.pdf");
            int readLen;
            char[] buffer = new char[1024];
            while ((readLen = fileReader.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void FileWr() {
        try {
            FileWriter fileWriter = new FileWriter("./hola.markdown");
            String words = "风雨之后一定会见彩虹";
            fileWriter.write(words);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
