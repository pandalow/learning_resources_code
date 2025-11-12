public class Ifelsedemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int marks = 75;
		String grade;
		
		if(marks >= 70 && marks <= 100) {
			grade = "First class honor";
		}
		else if (marks < 70 && marks >= 60) {
			grade ="you have pass the exam";
		}else {
			grade = "Fail";
		}
		
		System.out.println("Grade=" + grade);

	}

}
