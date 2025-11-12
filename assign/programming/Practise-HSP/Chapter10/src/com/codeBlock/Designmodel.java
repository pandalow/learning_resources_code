package com.codeBlock;

public class Designmodel {
    public static void main(String[] args) {
        Person p2 = Person.getInstance();

        System.out.println(p2.toString());
    }

}

class Person{
    private static Person p1 = new Person();
    private String name;
    private Person(){
        this.name = "Cindy";
    }

    public static Person getInstance(){
        return p1;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
