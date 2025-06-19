package com.pandalow;

public class LambdaTest {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
