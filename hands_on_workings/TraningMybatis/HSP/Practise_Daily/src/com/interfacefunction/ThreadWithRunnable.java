package com.interfacefunction;

public class ThreadWithRunnable{
    public static void main(String[] args) {
//        Runnable runnable = new Runnable(){
//            @Override
//            public void run(){
//                System.out.println("Thread created the usual way is running");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        };

        Runnable runnable = () -> {
            System.out.println("Thread created using lambda");
        };

        Thread t1 = new Thread(runnable);
        t1.start();
    }


}
