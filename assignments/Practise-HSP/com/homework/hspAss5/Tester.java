package com.homework.hspAss5;

public class Tester {
    public static void main(String[] args) {
        System.out.println(new Worker(200).fullSal());
        System.out.println(new Peasant(250).fullSal());
        System.out.println(new Teacher(250, 22, 30).fullSal());
        System.out.println(new Scientist(300, 500).fullSal());
        System.out.println(new Waiter(222).fullSal());
    }
}
