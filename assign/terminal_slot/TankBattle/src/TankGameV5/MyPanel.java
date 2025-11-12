package TankGameV5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener, Runnable {
    HeroTank heroTank = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    Vector<Bomb> bombs = new Vector<>();
    Vector<Node> nodes = new Vector<>();
    int enemySize = 4;

    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel(String key) {
        nodes = Recorder.getNodesAndTankRec();
        Recorder.setEnemyTanks(this.enemyTanks);
        heroTank = new HeroTank(100, 100);
        heroTank.setSpeed(3);
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));

        AePlayWave aePlayWave = new AePlayWave("./111.wav");
        aePlayWave.start();
        switch (key) {
            case "1":
            for (int i = 0; i < enemySize; i++) {
                EnemyTank enemyTank = new EnemyTank((i + 2) * 100, 300);
                enemyTank.setEnemyTanks(enemyTanks);
                enemyTank.setDirect(0);
                Thread thread = new Thread(enemyTank);
                thread.start();
                enemyTanks.add(enemyTank);
                enemyTanks.get(i).shotBullet();
            }
            break;
            case "2":
                for (int i = 0; i < nodes.size(); i++) {
                    Node node = nodes.get(i);
                    EnemyTank enemyTank = new EnemyTank(node.getX(),node.getY());
                    enemyTank.setEnemyTanks(enemyTanks);
                    enemyTank.setDirect(node.getDirect());
                    Thread thread = new Thread(enemyTank);
                    thread.start();
                    enemyTanks.add(enemyTank);
                    enemyTanks.get(i).shotBullet();
                }
                break;
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        showInfo(g);
        g.fillRect(0, 0, 1000, 950);
        // Draw User Tank
        if (heroTank != null && heroTank.isLive) {
            drawTank(heroTank.getX(), heroTank.getY(), g, heroTank.getDirect(), 0);
        }

        for (int i = 0; i < heroTank.bullets.size(); i++) {
            Bullet bullet = heroTank.bullets.get(i);
            if (bullet != null && bullet.isLive) {
                g.drawOval(bullet.getX(), bullet.getY(), 2, 2);
            } else {
                heroTank.bullets.remove(bullet);
            }
        }

        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if (enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);

                for (int j = 0; j < enemyTank.bullets.size(); j++) {
                    Bullet bullet = enemyTank.bullets.get(j);
                    if (bullet.isLive) {
                        g.drawOval(bullet.getX(), bullet.getY(), 2, 2);
                    } else {
                        enemyTank.bullets.remove(bullet);
                    }
                }
            }
        }
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 30, 30, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 30, 30, this);
            } else if (bomb.life > 1) {
                g.drawImage(image3, bomb.x, bomb.y, 30, 30, this);
            }
            bomb.lifeDown();
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }
    }

    public void showInfo(Graphics g) {
        g.setColor(Color.black);
        g.drawString("累计击毁的坦克", 1020, 30);

        drawTank(1020, 60, g, 0, 1);
        g.setColor(Color.black);
        g.drawString(Recorder.getAllEnemyNums() + "", 1080, 100);
    }

    public void hitHero() {
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = 0; j < enemyTank.bullets.size(); j++) {
                Bullet bullet = enemyTank.bullets.get(j);
                if (heroTank.isLive && bullet.isLive) {
                    hitTank(bullet, heroTank);
                }
            }
        }
    }

    public void hitEnemyTank() {
        for (int j = 0; j < heroTank.bullets.size(); j++) {
            Bullet bullet = heroTank.bullets.get(j);
            if (bullet != null && bullet.isLive) {
                for (int i = 0; i < enemyTanks.size(); i++) {
                    hitTank(bullet, enemyTanks.get(i));
                }
            }
        }

    }

    public void hitTank(Bullet bullet, Tank enemyTank) {
        switch (enemyTank.getDirect()) {
            case 0:
            case 2:
                if (bullet.getX() > enemyTank.getX() && bullet.getX() < (enemyTank.getX() + 40) &&
                        bullet.getY() > enemyTank.getY() && bullet.getY() < enemyTank.getY() + 60) {
                    bullet.isLive = false;
                    enemyTank.isLive = false;
                    if (enemyTank instanceof EnemyTank) {
                        Recorder.addAllEnemyNums();
                    }
                    enemyTanks.remove(enemyTank);

                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1:
            case 3:
                if (bullet.getX() > enemyTank.getX() && bullet.getX() < (enemyTank.getX() + 60) &&
                        bullet.getY() > enemyTank.getY() && bullet.getY() < enemyTank.getY() + 40) {
                    bullet.isLive = false;
                    enemyTank.isLive = false;
                    if (enemyTank instanceof EnemyTank) {
                        Recorder.addAllEnemyNums();
                    }
                    enemyTanks.remove(enemyTank);
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }

        }
    }

    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }
        switch (direct) {
            case 0:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.drawOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.drawOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y);
                break;
            case 2:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.drawOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.drawOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            heroTank.setDirect(0);
            if (heroTank.getY() > 0) {
                heroTank.moveUp();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            heroTank.setDirect(1);
            if (heroTank.getX() + 60 < 1000) {
                heroTank.moveRight();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            heroTank.setDirect(2);
            if (heroTank.getY() + 60 < 750) {
                heroTank.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            heroTank.setDirect(3);
            if (heroTank.getX() > 0) {
                heroTank.moveLeft();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {
//            if (heroTank.bullet == null || !heroTank.bullet.isLive) {
            heroTank.shotBullet();
//            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            hitHero();
            hitEnemyTank();
            this.repaint();
        }
    }
}
