package com.interfacefunction;

import java.util.function.Function;

public final class ConstructorExample {

    private String message;

    public ConstructorExample(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static void main(String[] args) {

        Function<String,ConstructorExample> s = ConstructorExample::new;
        ConstructorExample ddd= s.apply("Hello");
    }
}
