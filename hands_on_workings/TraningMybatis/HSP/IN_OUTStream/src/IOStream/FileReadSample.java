package IOStream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReadSample {

    @Test
    public void ReadFromFile(){
        String path = "1MF1.pdf";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
            char read;
            byte[] buffer = new byte[1024];
            while((fileInputStream.read(buffer))!=-1){
                System.out.print(new String(buffer,0,1024));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch(IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
