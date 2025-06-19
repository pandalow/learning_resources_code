package com.homework.hspAss1;

public class Tester {
    public static void main(String[] args) {
        Person p1 = new Person("John",10,"Doctor");
        Person p2 = new Person("Cindy",5,"Worker");
        Person p3 = new Person("Nicola", 20,"Interpreter");

        Person[] arr = {p1,p2,p3};

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i; j < arr.length-1; j++) {
                if( arr[j].getAge() > arr[j+1].getAge()){
                    Person temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i].toString());
        }
    }
}
