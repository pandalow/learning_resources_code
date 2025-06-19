/** @author zhuangxiaojian
 */
import java.util.Scanner;
public class LeapYear {

	public static void main(String[] args) {
		
		/*  1. Create Scanner objective
			2. Print out notice information
		 	3. User inputs 'year'*/
		Scanner scan = new Scanner(System.in);
		System.out.print("Please Enter Year: ");
		int year = scan.nextInt();
		
		
		/* Using If/else Statement
		 * if (if the year also divisible by 400) Or (the year is divisible by 4 but not by 100)  
		 * then will output 'year is leap year'
		 * else will output 'year is not leap year'
		 */
		if(year%400 == 0 || (year%4 == 0 && year % 100 != 0)) {
			System.out.println(year + " is leap year");
		} else {
			System.out.println(year + " is not leap year");
		}
	}
}
