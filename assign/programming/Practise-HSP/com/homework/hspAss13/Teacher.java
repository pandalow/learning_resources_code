package com.homework.hspAss13;

public class Teacher extends Person {

    private int work_age;


    public Teacher(String name, char sex, int age, int work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }

    public int getWork_age() {
        return work_age;
    }


    public String teach() {
        return "我承诺，我会认真教学";
    }

    @Override
    public String play() {
        return super.getName() + "爱玩象棋";
    }

    @Override
    public void printInfo() {
        System.out.println("老师的信息\n姓名：" + getName() + "\n年龄：" + getAge() + "\n性别" + getSex() + "\n工龄：" + getWork_age() + "\n" + teach() + "\n" + play());
    }
}
