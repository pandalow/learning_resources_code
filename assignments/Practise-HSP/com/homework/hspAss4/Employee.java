package com.homework.hspAss4;

public class Employee {
    private String name;
    protected double salary;
    protected int workdays;

    public Employee(String name, double salary, int workdays) {
        this.name = name;
        this.salary = salary;
        this.workdays = workdays;
    }

    public void printSalary(){
        System.out.println(workdays * salary);
    }
}
