package com.randomrw;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileExample {
    public static void main(String[] args) {
        String filePath = "example.txt";

        try {
            // 创建一个RandomAccessFile实例，以读写模式("rw")打开文件
            RandomAccessFile file = new RandomAccessFile(filePath, "rw");

            // 写入数据到文件
            file.writeUTF("Hello, World!"); // 写入一个字符串
            file.writeInt(123); // 写入一个整数
            file.writeDouble(45.67); // 写入一个双精度浮点数

            // 将文件指针移动到文件开头
            file.seek(0);

            // 从文件中读取数据
            System.out.println("Stored String: " + file.readUTF());
            System.out.println("Stored Integer: " + file.readInt());
            System.out.println("Stored Double: " + file.readDouble());

            // 关闭文件
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}