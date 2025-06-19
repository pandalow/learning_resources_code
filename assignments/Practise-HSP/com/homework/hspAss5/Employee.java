package com.homework.hspAss5;

public class Employee {
    private double sal;
    private int salMonth;

    public Employee(double sal) {
        this.sal = sal;
    }

    public double fullSal(){
        return sal*salMonth;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public void setSalMonth(int salMonth) {
        this.salMonth = salMonth;
    }

    public double getSal() {
        return sal;
    }

    public int getSalMonth() {
        return salMonth;
    }
}
