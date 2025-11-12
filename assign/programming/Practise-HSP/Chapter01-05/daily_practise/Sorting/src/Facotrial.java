
public class Facotrial {
	public static void main(String[] args) {

		class Recursion {
			int rec(int n) {
				if (n == 1) {
					return 1;
				} else {
					return n * rec(n - 1);
				}
			}
		}
		Recursion recur = new Recursion();
		
		System.out.println(recur.rec(5));
		
		
	}
}
