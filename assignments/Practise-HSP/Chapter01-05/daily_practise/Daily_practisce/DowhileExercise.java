
public class DowhileExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		int n = 200;
		int x = 0;

		do {
			if (i % 5 == 0 && i % 3 != 0) {
				x++;
			}
			i++;
		} while (i <= n);
		System.out.println(x);
	}

}
