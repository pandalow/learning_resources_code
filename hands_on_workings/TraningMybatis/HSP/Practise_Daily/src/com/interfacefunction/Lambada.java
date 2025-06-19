package com.interfacefunction;

public class Lambada {
    public static void main(String[] args) {

        Computable computable = (a,b)-> a+b;

        computable.sum(5,10);
    }
}
