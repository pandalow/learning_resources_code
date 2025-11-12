import java.util.Scanner;
public class Switchexercise3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner month =  new Scanner(System.in);
		
		int mon = month.nextInt();
		
		switch(mon) {
		case 3 :
		case 4 :
		case 5 :
			System.out.println("Spring");
		}
	}

}
