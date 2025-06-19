import java.util.Scanner;
public class BranchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s1 = new Scanner(System.in);
		
		System.out.print("Please enter your age");
		
		int age = s1.nextInt();
				
		if( age > 18 ) {
			System.out.println("You can have a nice trip");
		} else {
			System.out.println("You are died");
		}

	}

}
