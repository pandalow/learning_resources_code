package IOStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) {
        copyFile();
    }

    public static void copyFile() {
        String scrPath = "1MF1.pdf";
        String destPath = "./src/1M.pdf";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            byte[] buffer = new byte[1024];
            int read = 0;
            fileInputStream = new FileInputStream(scrPath);
            fileOutputStream = new FileOutputStream(destPath);
            while ((read = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
