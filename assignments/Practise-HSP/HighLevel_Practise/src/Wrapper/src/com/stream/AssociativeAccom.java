package Wrapper.src.com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AssociativeAccom {
    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1,6,10,5);

       int n =  integers.stream().reduce(0,(a, b)->a+b);
        System.out.println(n);

        List<Integer> list = integers.stream().filter(e -> e%2 == 0).collect(Collectors.toList());

        list.stream().forEach(System.out::println);


    }
}
