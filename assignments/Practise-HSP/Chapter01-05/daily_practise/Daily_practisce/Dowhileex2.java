import java.util.Scanner;

public class Dowhileex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String input;

		do {
			System.out.println("Pay the mnoney! y/n");
			 input= scanner.next();
		} while (!input.equals("y"));
	}

}
