package com.produce_consume;

import java.util.Arrays;

public class SharedBuffer {
    private final int capacity;
    private final int[] buffer;
    private int count;
    public SharedBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.count = 0;
    }
    public synchronized void produce(int item) throws InterruptedException {
// Implement the producer logic here

        while(count == capacity){
            System.out.println("the buffer is full");
            wait();
        }
            buffer[count++] = item;
        System.out.println("Produce item No: " +  Arrays.toString(buffer));
        notify();
    }

    public synchronized int consume() throws InterruptedException {
// Implement the consumer logic here

        while(count == 0){
            System.out.println("the buffer is empty");
            wait();
        }
        int item = buffer[--count];
        System.out.println("Consume item No:" + Arrays.toString(buffer));

        notify();
        return item;

    }
}