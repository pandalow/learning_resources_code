package com.homework.hspAss4;

public class Manager extends Employee{
    public Manager(String name, double salary, int workdays) {
        super(name, salary, workdays);
    }

    @Override
    public void printSalary() {
        System.out.println(1000 + salary * workdays * 1.2);
    }
}
