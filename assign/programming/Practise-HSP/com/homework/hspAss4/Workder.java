package com.homework.hspAss4;

public class Workder extends  Employee{
    public Workder(String name, double salary, int workdays) {
        super(name, salary, workdays);
    }

    @Override
    public void printSalary() {
        System.out.println(salary * workdays * 1.0);
    }
}
