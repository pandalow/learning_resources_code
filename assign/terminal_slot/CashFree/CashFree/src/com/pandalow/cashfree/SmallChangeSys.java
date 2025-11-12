package com.pandalow.cashfree;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class SmallChangeSys {
    public static void main(String[] args) {
        boolean loop = true;
        Scanner scan = new Scanner(System.in);

        String details = "------零钱通明细------";
        double cash = 0;
        Date date = null;
        double balance = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm");
        String note = null;


        do {
            System.out.println("\n=======零钱通=======");
            System.out.println("\t 1.零钱通明细");
            System.out.println("\t 2.收益入账");
            System.out.println("\t 3.消费");
            System.out.println("\t 4.退出");

            int input = scan.nextInt();

            switch (input) {
                case 1:
                    System.out.println(details);
                    break;
                case 2:
                    System.out.println("收入金额：");
                    cash = scan.nextDouble();
                    balance += cash;
                    date = new Date();
                    details += "\n收益入账：\t" + cash + "\t" + sdf.format(date) + "\t余额：\t" + balance;
                    break;
                case 3:
                    System.out.println("输入消费金额：");
                    cash = scan.nextDouble();
                    // verify
                    System.out.println("请输入消费说明：");
                    note = scan.next();
                    balance -= cash;
                    details += "\n" + note + "\t-" + cash + "\t" + sdf.format(date) + "\t余额：\t" + balance;
                    break;
                case 4:
                    String confirm;
                    while (true) {
                        System.out.println("请确认是否要退出？回答y/n");
                        confirm = scan.next();
                        if (confirm.equals("y") || confirm.equals("n")) {
                            break;
                        } else {
                            System.out.println("重新输入指令");
                        }
                    }
                    if (confirm.equals("y")) {
                        loop = false;
                    }
                    break;
                default:
                    System.out.println("你的输入有误");
            }
        }
        while (loop);
        System.out.println("已退出该程序");
    }
}
