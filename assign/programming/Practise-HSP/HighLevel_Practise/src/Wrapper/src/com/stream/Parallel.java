package Wrapper.src.com.stream;

import java.util.*;
import java.util.stream.IntStream;

public class Parallel {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        IntStream stream = Arrays.stream(array);
        stream.forEach(s -> {
            System.out.println(s + " " + Thread.currentThread().getName());
        });

        System.out.println("+++++++++++++++++++++++++++++");

        IntStream parallelStream = Arrays.stream(array).parallel();
        parallelStream.forEach(s->{
            System.out.println(s+" "+ Thread.currentThread().getName());
        });
    }
}
