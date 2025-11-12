package com.homework.hspAss5;

public class Teacher extends Employee{
    private int classDay;
    private double classSal;
    public Teacher(double sal,int classD,double classS) {
        super(sal);
        classDay = classD;
        classSal = classS;
    }

    @Override
    public double fullSal() {
        return getSal() * getSalMonth() + classDay * classSal;
    }
}
