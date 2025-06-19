package com.interfacefunction;

import java.util.function.BiFunction;
import java.util.function.DoubleFunction;

public class RefToStatic {
    public static void main(String[] args) {
        DoubleFunction<Double> d = Math::sqrt;
        System.out.println(d.apply(81));

        BiFunction<Integer,Integer,Integer> s= Math::min;
        System.out.println(s.apply(6,13));
    }
}
