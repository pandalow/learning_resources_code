package TankGame;

import javax.swing.*;

public class ZhuangTankGame1 extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        new ZhuangTankGame1();

    }

    public ZhuangTankGame1(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
