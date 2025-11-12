import java.util.Scanner;
import java.text.DecimalFormat;

public class Totalsales {
	public static void main(String[] args) {
		//import input objective
		Scanner input;
		input = new Scanner(System.in); 
		
		//Format Decimal
		DecimalFormat df;
		df = new DecimalFormat("0.00");
		
		//Input console
		System.out.print("Enter number of A seats sold:");
		int num1 = input.nextInt();
		System.out.print("Enter price of A tickets:");
		double db1 = input.nextDouble();
		
		System.out.print("Enter number of B seats sold:");
		int num2 = input.nextInt();
		System.out.print("Enter price of B tickets:");
		double db2 =input.nextDouble();
		
		System.out.print("Enter number of C seats sold:");
		int num3 = input.nextInt();
		System.out.print("Enter price of C tickets:");
		double db3 = input.nextDouble();

		//Calculate total sales
		double sal = (num1 * db1) + (num2 * db2) + (num3 * db3);
		
		//Output order of price & sums
		System.out.println("\n\t\tTicket Sold\tPrice per Ticket"
				+ "\n\t\t---------\t---------"
				+ "\nA Tickets\t" + num1 + "\t\t" + df.format(db1) 
				+ "\nB Tickets\t" + num2 + "\t\t" + df.format(db2)
				+ "\nC Tickets\t" + num3 + "\t\t" + df.format(db3));
		System.out.println("\tTotal sales €" + df.format(sal));
		
		input.close();
	}
}

/*	System.out.println("");
System.out.println(");
System.out.println();
System.out.println("C Tickets\t" + num3 + "\t" + db3);

*/

