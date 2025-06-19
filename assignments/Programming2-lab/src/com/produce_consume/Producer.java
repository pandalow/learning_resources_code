package com.produce_consume;

public class Producer extends Thread {

    private final SharedBuffer sharedBuffer;

    public Producer(SharedBuffer sharedBuffer) {

        this.sharedBuffer = sharedBuffer;

    }

    @Override
    public void run() {
        // Implement the producer's run logic here
        int i = 0;
        while(true) {
            try {
                sharedBuffer.produce(i++);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        }
    }
}
