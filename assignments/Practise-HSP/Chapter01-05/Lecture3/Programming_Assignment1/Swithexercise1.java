import java.util.Scanner;
public class Swithexercise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner upper  = new Scanner(System.in);
		char word = upper.next().charAt(0);
		
	
		switch(word){
			case 'a' :
				System.out.println('A');
				break;
			case 'b' :
				System.out.println('B');
				break;
			case 'c' :
				System.out.println('C');
				break;
			case 'd' :
				System.out.println('D');
				break;
			case 'e' :
				System.out.println('e');
				break;
			default :
				System.out.println("other");
				break;		
		}
	}

}
