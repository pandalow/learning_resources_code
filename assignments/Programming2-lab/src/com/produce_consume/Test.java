package com.produce_consume;

public class Test {
    public static void main(String[] args) {
        SharedBuffer sharedBuffer = new SharedBuffer(5);

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                // Implement the producer's run logic here
                int i = 0;
                while (true) {
                    try {
                        sharedBuffer.produce(i++);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println(sharedBuffer.consume());
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        producer.start();
        consumer.start();

    }
}
