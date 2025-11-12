package com.pandalow.cashfreeOOP;

import java.util.Scanner;

public class SmallChangeSysApp {
    public static void main(String[] args) {
        new SmallChangeSysOOP().start();
        while (true) {
            try {
                System.out.println("111");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
