package com.Stream;

import java.util.ArrayList;

public class Terminal {
    public static void main(String[] args) {

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("One");
        list2.add("Three");
        list2.add("Four");

        list2.stream().anyMatch(e->e.contains("o"));// return boolean value; OR
        list2.stream().allMatch(e->e.contains("e"));// AND
        list2.stream().noneMatch(e->e.contains("a"));// No ALL
    }
}
