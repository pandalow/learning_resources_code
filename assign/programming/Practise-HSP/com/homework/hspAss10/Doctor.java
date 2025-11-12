package com.homework.hspAss10;

public class Doctor {
    private String name;
    private int age;
    private String job;
    private String gender;
    private double sal;

    public Doctor(String name, int age, String job, String gender, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public String getGender() {
        return gender;
    }

    public double getSal() {
        return sal;
    }

//    @Override
//    public boolean equals(Object obj){
//
//    }

}
