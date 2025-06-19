package IOStream;

import org.junit.Test;

import java.io.*;

public class BufferedStreamCopy {
    @Test
    public void BufferedCopy() throws IOException {
        BufferedInputStream inputStream =
                new BufferedInputStream(new FileInputStream("./1MF1.pdf"));
        BufferedOutputStream outputStream =
                new BufferedOutputStream(new FileOutputStream("./cool.pdf"));

        int read = 0;
        byte[] b = new byte[1024];
        while ((read = inputStream.read(b)) != -1){
            outputStream.write(b,0,read);
        }
        outputStream.close();
        inputStream.close();
    }
}
