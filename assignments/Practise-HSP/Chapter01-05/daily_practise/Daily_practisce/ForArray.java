/** @author zhuangxiaojian 23101934
 * 	@version 1.0*/

import java.util.Scanner;
import java.text.DecimalFormat;
public class ForArray {

	public static void main(String[] args) {
		
		// 1. Create Scanner objective
		// 2. Print out notice information
		
		Scanner scan =  new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.print("Please Enter Array Length: ");
		
		// 1. Assign the 'size1' to the scanner;
		// 2. Assign 'size1' as the array length parameter to the nums array variable
			
		int size1 = scan.nextInt();
		double[] nums = new double[size1];
			
		// 3. Use a 'for' loop to set the local variable i. When i < size1 ,increase +1
		// 4. Get the value of 'num' entered by the user through i until the end of the loop
		// 5. The array starts with 0, so the actual user perceives the first number as i+1
			
		for(int i = 0; i < size1; i++) {
			System.out.print("Please Enter No." + (i+1) + " Number: ");
				nums[i] = scan.nextDouble();
		}
			
		// Populate all the numbers which user input
		for(int i = 0; i < size1;i++) {
			System.out.println("Number" + (i+1) + " is " + nums[i]);
		}
		// 1. Declare sum as a double variable and initialize to 0
		/* 2. Use a for loop and use the formula (sum += nums[i]) equals
			(sum all = sum + nums[i]) to calculate the total values */
		
		double sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		// Using decimal to format double with 0.00	
		System.out.println("the sum = "+ df.format(sum));

	}
}
