package com.anaName;

public class AnonymousInnerClass {
    public static void main(String[] args) {
    new Outer04().method();
    }
}

class Outer04{
    private int n1 = 10;
    public void method(){
        IA ia = new IA() {
            @Override
            public void cry() {
                System.out.println("tiger cry");
            }
        };                    ia.cry();
        Father father = new Father("jack"){
            @Override
            public void test(){
                System.out.println("Overrride");
            }
        };
        System.out.println("father" + father.getClass());
        father.test();
    }
}

interface IA{
    public void cry();
}

class Father{
private String name;

    public Father(String name) {
        this.name = name;
    }
    public void test(){}
}
