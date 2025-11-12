package com.fileStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageFileCopy {
    public static void main(String[] args) {
        String sourceFilePath = "class.png";
        String destinationFilePath = "nuig-copy.jpg";

        FileInputStream input =null;
        FileOutputStream output = null;

        try {
            input = new FileInputStream(sourceFilePath);
            output = new FileOutputStream(destinationFilePath);

            int byteRead;

            while((byteRead = input.read()) != -1){
                output.write(byteRead);
            }
            input.close();
            output.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
