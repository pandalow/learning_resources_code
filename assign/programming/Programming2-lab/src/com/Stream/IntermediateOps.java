package com.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOps {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");

        Stream<String> stream = list.stream().filter(e-> e.contains("o"));
        // stream.filter() is not running; 这里返回一个新的stream对象， 所以原先的stream不能使用
        stream.forEach(System.out::println); // Method reference;

        //Mapping
        Stream<String> stream2 = list.stream().map(String::toUpperCase);
        stream2.forEach(System.out::println);

        //Remove Duplicates
        List<Integer> nums = Arrays.asList(1,2,2,3,3,4,5);
        Stream<Integer> distinctNums = nums.stream().distinct();
        distinctNums.forEach(System.out::println);

        //Sorted
        Stream<String> sortedStream = list.stream().sorted();
        sortedStream.forEach(System.out::println);

        //Skip
        Stream<String> skipStream = list.stream().skip(2);
        skipStream.forEach(System.out::println);

        Stream<Integer> skipNums = nums.stream().skip(2);
        skipNums.forEach(System.out::println);

    }
}
