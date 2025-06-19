package Homework_throws;
import java.util.Scanner;
public class Homework01 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num1;
        int num2;

        Object num3 = new Integer(11);
        System.out.println(num3.hashCode());
        while(true){
        System.out.print("Enter your int int number1");
            try {
                num1 = Integer.parseInt(scan.next());
                break;
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            finally{
            }
        }
        while(true){
        System.out.print("Enter your int int number2");
            try {
                num2 = Integer.parseInt(scan.next());
                break;
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            finally{}
        }

        try{
            cal(num1,num2);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
        }
        }

    public static void cal(int n1, int n2) throws ArithmeticException{
        System.out.println(n1/n2);
    }
}
