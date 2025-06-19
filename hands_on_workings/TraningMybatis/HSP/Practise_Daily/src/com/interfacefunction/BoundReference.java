package com.interfacefunction;

import java.util.function.Supplier;

public class BoundReference {

    private final String name;

    public BoundReference(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        BoundReference r1 = new BoundReference("r1");
        BoundReference r2 = new BoundReference("r2");

        Supplier<String> supplier = r1::getName;
        System.out.println(supplier.get());

        supplier = r2::getName;
        System.out.println(supplier.get());

    }

    public String getName() {
        return name;
    }
}
