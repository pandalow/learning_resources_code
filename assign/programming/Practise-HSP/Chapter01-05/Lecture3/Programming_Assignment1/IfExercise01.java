
public class IfExercise01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double n1 = 11.2;
		double n2 = 9.5;
		
		if(n1 > 10.0 && n2 < 20.0) {
			System.out.println("两个数和= " +(n1 + n2));
		}
		int num1 = 5;
		int num2 = 10;
		int num3 = num1 + num2;
		if(num3%3 == 0 && num3%5 == 0) {
			System.out.println("Good job");
		}
		int year = 2001;
		if ((year%4 == 0 && year%100 != 0) || year%400 == 0) {
			System.out.println("It's Leap Year");
		}
			
	}
		
}



