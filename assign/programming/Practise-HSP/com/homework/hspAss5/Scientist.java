package com.homework.hspAss5;

public class Scientist extends  Employee{
private double bonus;

    public Scientist(double sal, double bon) {
        super(sal);
        bonus = bon;
    }

    @Override
    public double fullSal() {
        return bonus + super.fullSal();
    }
}
