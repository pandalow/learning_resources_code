package com.optimizie;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Robust {
    public static void main(String[] args) {
        String sourceFilePath = "class.png";
        String destinationFilePath = "nuig-copy.jpg";


        try (FileInputStream input = new FileInputStream(sourceFilePath);
             FileOutputStream output = new FileOutputStream(destinationFilePath);) {


            int byteRead;
            byte[] buffer = new byte[1024];

            long start = System.currentTimeMillis();
            while ((byteRead = input.read(buffer)) != -1) {
                output.write(buffer);
            }
            long end = System.currentTimeMillis();
            long time = end - start;
//            input.close();
//            output.close();
            System.out.println(time + "ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}