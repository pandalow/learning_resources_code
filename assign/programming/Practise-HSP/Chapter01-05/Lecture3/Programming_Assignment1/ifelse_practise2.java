import java.util.Scanner;
public class ifelse_practise2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter month : ");
		int month = scanner.nextInt();
		
		System.out.print("Please enter your age :" );
		int age = scanner.nextInt();
		
		double price = 60;
		
		if(month <= 10 && month >= 4) {		
				if(age < 18) {
					System.out.println("Your price is :" + (price / 2));
				}else if (age > 60) {
					System.out.println("Your price is :" + (price / 3));
				}else {
					System.out.println("Your price is :" + price);				
				}		
		}else if((month >=10 && month <= 12)||(month <=4 && month >= 1)){
				if(age<=60 && age >= 18) {
					System.out.println("Your price is :" + price);
				}else {
					System.out.println("Your price is :" + (price/3));
				}
			
		}else {System.out.println("Invalid month input");
			
		}
	}

}
