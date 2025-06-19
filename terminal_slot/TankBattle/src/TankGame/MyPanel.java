package TankGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

public class MyPanel extends JPanel {
    HeroTank heroTank =null;
    private int x;
    private int y;
    public MyPanel(){
        x = 100;
        y = 100;
        heroTank = new HeroTank(x,y);

    }

    public void paint(Graphics g){
        super.paint(g);
        g.fillRect(0,0,1000,750);

        drawTank(heroTank.getX(),heroTank.getY(),g,0,0);
        drawTank(heroTank.getX()+100,heroTank.getY(),g,0,1);
    }
    public void drawTank(int x, int y,Graphics g,int direct,int type){
        switch (type){
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }
        switch(direct){
            case 0:
                g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(x+10,y+10,20,40,false);
                g.fill3DRect(x+30,y,10,60,false);
                g.drawOval(x+10,y+20,20,20);
                g.drawLine(x+20,y+30,x+20,y);
        }
    }
}
