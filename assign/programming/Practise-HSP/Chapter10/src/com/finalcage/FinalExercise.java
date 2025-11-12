package com.finalcage;

public class FinalExercise {
    private double radius;
    private final double PI;
    {
        PI = 3.14;
    }
    public FinalExercise(){
        radius = 5;
    }
    public void cal(){

        System.out.println(radius * radius * PI);
    }

    public static void main(String[] args) {
        new FinalExercise().cal();
    }
}
