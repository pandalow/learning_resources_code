import java.util.Scanner;

public class Array02 {
	public static void main(String[] args) {

		Scanner myScan = new Scanner(System.in);

		int[] num = new int[3];

		for (int i = 0; i < num.length; i++) {
			int value = myScan.nextInt();
			num[i] = value;
		}

		for (int p : num) {
			System.out.println(p);
		}

	}
}
