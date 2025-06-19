package Wrapper.src.com.m;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeWork2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String userName;
        String pwd;
        String email;
        while (true) {
            userName = scan.next();
            if ((userName.length() < 2 || userName.length() > 4)) {
                throw new UserNameException("Not vaild length");
            }
            pwd = scan.nextLine();
            if(!(pwd.length() == 6 && isDigital(pwd))){
                throw new UserNameException("Not vaild pwd");
            }
            System.out.println(" ");
            email = scan.nextLine();

        }
    }
    public static boolean isDigital(String pwd){
        char[] chars = pwd.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] < '0'|| chars[i] > '9'){
                return false;
            }
        }
        return true;
    }
}

class UserNameException extends RuntimeException {
    public UserNameException(String message) {
        super(message);
    }

}