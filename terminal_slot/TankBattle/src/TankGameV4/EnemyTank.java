package TankGameV4;

import java.util.Map;
import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
    Vector<Bullet> bullets = new Vector<>();
    Bullet bullet = null;

    public EnemyTank(int x, int y) {
        super(x, y);
    }


    public void shotBullet() {

        bullet = new Bullet(getX() + 20, getY() + 60, 2);
        bullets.add(bullet);
        Thread thread = new Thread(bullet);
        thread.start();
    }

    public void run() {
        while (true) {
            if(isLive && bullets.size() <= 5){
                switch (getDirect()){
                    case 0:
                        bullet = new Bullet(getX()+20,getY(),0);
                        break;
                    case 1:
                        bullet = new Bullet(getX()+60,getY()+20,1);
                        break;
                    case 2:
                        bullet = new Bullet(getX()+20,getY()+60,2);
                        break;
                    case 3:
                        bullet = new Bullet(getX(),getY()+20,3);
                        break;
                }
                bullets.add(bullet);
                new Thread(bullet).start();
            }

            switch (getDirect()) {
                case 0:
                    for (int i = 0; i < 30; i++) {
                        if (getY() > 0) {
                            moveUp();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case 1:
                    for (int i = 0; i < 30; i++) {
                        if (getX() + 60 < 1000) {
                            moveRight();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        if (getY() + 60 < 750) {
                            moveDown();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        if (getX() > 0) {
                            moveLeft();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }
            setDirect((int) (Math.random() * 4));
            if (!isLive) {
                break;
            }
        }
    }
}
