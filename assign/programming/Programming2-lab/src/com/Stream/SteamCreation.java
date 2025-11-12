package com.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class SteamCreation {
    public static void main(String[] args) {
        /*
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> myStream = Arrays.stream(arr);
        myStream.forEach(e -> System.out.println(e));


        Stream<String> myStream2 = Stream.of("a","b","c");
        myStream2.forEach(e-> System.out.println(e));


        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Orange");
        list.add("Banana");

        Stream<String> myStream3 = list.stream();
        myStream3.forEach(e-> System.out.println(e));


        Stream.Builder<String> builder = Stream.builder();
        Stream<String> myStream4 = builder.add("x").add("y").add("z").build();


        Stream<String> myStream5 = Stream.generate(()->"hello").limit(10);//no limit - infinite loop ->  keep on generate.
        myStream5.forEach(e-> System.out.println(e));


        Stream<Double> myStream6 = Stream.generate(()->Math.random()).limit(10);//no limit - infinite loop ->  keep on generate.
        myStream6.forEach(e-> System.out.println(e));

         */
        IntStream intStream = IntStream.range(1,5);// not included 5, included 1, using rangeClosed() can included 5;
        intStream.forEach(e-> System.out.println(e));

        LongStream longStream = LongStream.rangeClosed(1,5);
        longStream.forEach(e-> System.out.println(e));


    }
}
