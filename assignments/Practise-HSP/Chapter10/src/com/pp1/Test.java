package com.pp1;

interface Bell {
    void ring();
}

class CellPhone {

    public void alarmClock(Bell bell) {
        bell.ring();
    }
}

public class Test {
    public static void main(String[] args) {

        CellPhone cell = new CellPhone();
       cell.alarmClock(new Bell() {
            @Override
            public void ring(){
                System.out.println("Pig wake up");
            }
        });
    }
}
