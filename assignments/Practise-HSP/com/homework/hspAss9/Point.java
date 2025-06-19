package com.homework.hspAss9;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class LabeledPoint extends Point{
    private String label;
    public LabeledPoint(String label, int x, int y) {
        super(x,y);
        this.label = label;
    }
}
