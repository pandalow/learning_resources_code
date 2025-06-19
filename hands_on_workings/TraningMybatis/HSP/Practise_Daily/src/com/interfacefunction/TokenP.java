package com.interfacefunction;

import java.util.Scanner;
public class TokenP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入命令和语句：");
        String command = scanner.next(); // 读取命令（第一个token）
        String statement = scanner.nextLine().trim(); // 读取命令后的整个语句，并去除首尾空格

        System.out.println("命令：" + command);
        System.out.println("语句：" + statement);
    }
}
