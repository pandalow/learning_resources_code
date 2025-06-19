package org.example;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private JPanel number;
    private JButton button;

    public Main(){
        init();
    }
    public static void main(String[] args) {
        new Main().setVisible(true);
    }
    public void init(){
        setTitle("lotto");
        setSize(500,200);

        number= new JPanel();
        number.setBackground(Color.CYAN);

        button = new JButton();

        add(number,BorderLayout.CENTER);
        add(button,BorderLayout.PAGE_END);
    }

}