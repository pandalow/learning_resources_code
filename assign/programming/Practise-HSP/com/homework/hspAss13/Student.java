package com.homework.hspAss13;

public class Student extends Person{
    private int stu_id;


    public Student(String name, char sex, int age, int stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public String study() {
        return "我承诺，我会好好学习";
    }

    @Override
    public String play() {
        return super.getName() + "爱玩足球";
    }

    @Override
    public void printInfo() {
        System.out.println("学生的信息\n姓名：" + getName() + "\n年龄：" + getAge() + "\n性别" + getSex() + "\n工龄：" + getStu_id() + "\n" + study() + "\n" + play());
    }
}