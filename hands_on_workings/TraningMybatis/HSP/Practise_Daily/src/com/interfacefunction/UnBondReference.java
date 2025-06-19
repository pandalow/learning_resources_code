package com.interfacefunction;

import java.util.function.Function;

public class UnBondReference {
    private String name;

    public UnBondReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {

        UnBondReference r1 = new UnBondReference("1111");
        UnBondReference r2 = new UnBondReference("r2");

        Function<UnBondReference,String> d = UnBondReference::getName;
        System.out.println(d.apply(r1));
        System.out.println(d.apply(r2));
    }
}
