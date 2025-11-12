package com.homework.hspAss4;

public class Tester {
    public static void main(String[] args) {
        Employee employee = new Employee("Low",1100,22);
        Employee employee1 = new Employee("Elbow", 1220, 15);

        employee1.printSalary();
        employee.printSalary();

    }
}
