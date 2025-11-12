package com.anaName;

public class InnerClassExercise01 {
    public static void main(String[] args) {
        iaa(new IAA() {
            @Override
            public void show() {
                System.out.println("This is ananoamal");
            }
        });
    }

    public static void iaa(IAA iaa){
        iaa.show();
    }
}

interface IAA{
    void show();
}

