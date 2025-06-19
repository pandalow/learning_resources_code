package com.interfacefunction;

import java.util.function.Predicate;
public class NoLambda {
    public static void main(String[] args) {
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("d");
            }
        };
        System.out.println(predicate.test("dublin"));
    }
}
