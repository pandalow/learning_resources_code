package Exercise;

public class Employee {
    private String name;
    private String male;
    private int age;
    private String job;
    private double sal;

    public Employee(String name, String male, int age, String job, double sal) {
        this.name = name;
        this.male = male;
        this.age = age;
        this.job = job;
        this.sal = sal;
    }

    public Employee(String name, String male, int age) {
        this.name = name;
        this.male = male;
        this.age = age;
    }

    public Employee(String job, double sal) {
        this.job = job;
        this.sal = sal;
    }
}
