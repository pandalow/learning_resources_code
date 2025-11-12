package Exercise2;

import java.text.Format;

public class HomeWork02 {
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            System.out.println(Frock.getNextNum());
        }

        Frock fo1 = new Frock();
        System.out.println(fo1.getSerialNumber());
        Frock fo2 = new Frock();
        System.out.println(fo2.getSerialNumber());
        Frock fo3 = new Frock();
        System.out.println(fo3.getSerialNumber());

    }
}
class Frock {

    private static int currentNum = 100000;
    private int serialNumber;

    public Frock() {
        this.serialNumber = getNextNum();
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public static int getNextNum() {
        return currentNum += 100;
    }

}
