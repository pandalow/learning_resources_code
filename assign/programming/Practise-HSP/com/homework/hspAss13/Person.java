package com.homework.hspAss13;

public class Person {
    private String name;
    private char sex;
    private int age;

    public Person(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String play(){
        return getName() + "爱玩";
    }

    public void printInfo(){
        System.out.println("");
    }

    public static void main(String[] args){

        Person[] person = new Person[2];

        person[0] = new Teacher("张飞",'m',30,5);
        person[1] = new Student("小明",'m',15,00023102);

        person[0].printInfo();
        person[1].printInfo();
    }
}
