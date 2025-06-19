package com.filereader;

import java.io.EOFException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStream {
    public static void main(String[] args) {
        try {
            copy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copy() throws IOException {

        FileReader fileReader = null;
        FileWriter fileWriter = null;

        char[] buff = new char[100];
        try {
            fileReader = new FileReader("input.txt");
            fileWriter = new FileWriter("input-copy.txt");
            int c;
            while ((c = fileReader.read(buff)) != -1) {
                fileWriter.write(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            fileWriter.close();
            fileWriter.close();
        }
    }
}
