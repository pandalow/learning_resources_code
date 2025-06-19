import java.util.Scanner;
public class Switchexercise2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			Scanner scanner1  = new Scanner(System.in);
			int nums = scanner1.nextInt();
			
			
			
//			这道题需要我们用一个转换, 是编程思考;
//			 如果成绩在[60.100], 强行转换(int)(成绩/60) = 1
//			 如果成绩在[0.60], 强转(int)(成绩/60) = 0
//			保证输入成绩是有效的,用if-else校验
			
		if(nums >= 0 && nums <= 100) {
			switch((int)(nums / 60)) {
			case 1 :
				System.out.println("You have passed");
				break;
			case 0 :
				System.out.println("You do not pass");
				break;
			default :
				System.out.println("Wrong number");
			}
		}else {
			System.out.print("输入数字有误");
		}
		}
			
			
	}

}
