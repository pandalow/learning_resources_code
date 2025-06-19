package com.homework.hspAss2;

public class SubProf extends Homework03{
    public SubProf(String name, int age, String post, double salary) {
        super(name,age,post,salary);
    }

    @Override
    public String introduce(){
        return "Homework03{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", post='" + getPost() + '\'' +
                ", salary=" + (getSalary()*1.2) +
                '}';
    }
}
