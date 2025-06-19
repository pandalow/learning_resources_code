package com.produce_consume;

public class Consumer extends Thread {

    private final SharedBuffer sharedBuffer;

    public Consumer(SharedBuffer sharedBuffer) {

        this.sharedBuffer = sharedBuffer;

    }

    @Override

    public void run() {
        // Implement the consumer's run logic
        while(true){
            try {
                System.out.println(sharedBuffer.consume());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
