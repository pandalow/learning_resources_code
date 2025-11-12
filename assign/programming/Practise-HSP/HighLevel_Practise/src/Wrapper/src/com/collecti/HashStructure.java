package Wrapper.src.com.collecti;

import java.util.HashSet;
import java.util.Objects;

public class HashStructure {
    public static void main(String[] args) {

        HashSet<Employee> employees = new HashSet<>();
        employees.add(new Employee("zhuang",23));
        employees.add(new Employee("cindy",23));
        employees.add(new Employee("zhuang",23));
        employees.add(new Employee("zhuang",36));

        System.out.println(employees);


    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Employee employee = (Employee) object;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

//    public boolean equals(Object object) {
//
//        if (object instanceof Employee) {
//            if (((Employee) object).getAge() == this.age && ((Employee) object).getName() == this.name) {
//                return true;
//            } else return false;
//        } else return false;
//
//    }
}