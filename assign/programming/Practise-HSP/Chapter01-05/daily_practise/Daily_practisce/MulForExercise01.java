import java.util.Scanner;

public class MulForExercise01 {

	public static void main(String[] args) {

		Scanner myScan = new Scanner(System.in);
		
		int i = 0;
		while (i < 3) {
			System.out.println("The class number is " + i + 1);
			int score = 0;
			for (int p = 0; p < 5; p++) {
				System.out.print("Please enter score");
				int input = myScan.nextInt();
				score += input;
			}
			System.out.println("Class" + (i + 1) + "Average score is " + (score / 5));
			i++;
		}
	}
}
