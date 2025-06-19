import java.util.Scanner;
public class FlowChart01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		
		if (A > B){
			System.out.println("A");
		}else {
			System.out.println("B");
		}
		
		if((A / B) < (B * A)) {
			System.out.println("B");
		}else {
			System.out.println("A");
		}
	}

}
