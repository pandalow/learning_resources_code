public class FIndFactorial {
	public static void main(String args[]) {
		for (int i = 1; i < 10; i++)
			System.out.println(i + "! = " + findFactorial(i));
	}

	public static int findFactorial(int number) {
		if ((number == 1) || (number == 0))
			return 1;
		else
			return (number * findFactorial(number - 1));
	}
}