package com.homework.hspAss2;

public class Prof extends Homework03{
    public Prof(String name, int age, String post, double salary) {
        super(name,age,post,salary);
    }

    @Override
    public String introduce(){
        return "Homework03{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", post='" + getPost() + '\'' +
                ", salary=" + (getSalary()*1.3) +
                '}';
    }
}
