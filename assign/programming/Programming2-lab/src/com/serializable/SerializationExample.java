package com.serializable;

import java.io.*;
import java.util.Date;
public class SerializationExample {
    public static void main(String[] args) {

        FileOutputStream out = null;
        FileInputStream in = null;
        ObjectOutputStream oos =null;
        ObjectInputStream ois = null;


        try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("date.dat"));
            Date date = new Date();
            objectOutputStream.writeObject(date);
            objectOutputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("date.dat"));
            Date d = (Date)objectInputStream.readObject();
            System.out.println(d);
            objectInputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
