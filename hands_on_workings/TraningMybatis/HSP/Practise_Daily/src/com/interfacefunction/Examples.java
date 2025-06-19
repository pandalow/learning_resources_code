package com.interfacefunction;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Examples {
    public static void main(String[] args) {
        Predicate<String> isEmpty = s -> s.isEmpty();

        boolean empty = isEmpty.test("");

        System.out.println("Predicate" + empty);

        Supplier<Integer> getRandomNumber = ()-> (int)(Math.random() * 100) + 1;
        int num = getRandomNumber.get();
        System.out.println("Supplier" + num);

        Function<Integer, Integer> square = x -> x*x;
        int result = square.apply(5);
        System.out.println("Function" + result);

        BiFunction<Integer,Integer,Integer> add = (x,y) -> x+y;
        int sum = add.apply(4,3);
        System.out.println("BiFunction" + sum);
    }
}
