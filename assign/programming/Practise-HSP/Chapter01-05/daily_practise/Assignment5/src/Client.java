import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
        
		// Create a new Scanner object to read user input
		Scanner myScan = new Scanner(System.in);

		// Declare an array of 3 Student objects
		Student[] students = new Student[3];
		
		// Loop 3 times to get details for each student
		for (int i = 0; i < 3; i++) {

			// Prompt the user to specify if the student is PostGraduate or UnderGraduate
			System.out.print("Is the student a PostGraduate or UnderGraduate? press p/u :");
			char isTrue = myScan.next().charAt(0);

			// Validate the input until a valid choice (p/u) is made
			while (isTrue != 'p' && isTrue != 'u') {
				System.out.print("Please Enter the valid value :");
				isTrue = myScan.next().charAt(0);
			}

			// If user chooses 'p', initialize the student as a PostGraduate, otherwise as an UnderGraduate
			if (isTrue == 'p') {
				students[i] = new PostGraduate();
			} else if (isTrue == 'u') {
				students[i] = new UnderGraduate();
			}

			// Prompt the user to enter the student's name
			System.out.print("Please Enter the student " + (i + 1) + " Name: ");
			String name = myScan.next();
			students[i].setName(name);

			// Prompt the user to enter the student's ID
			System.out.print("Please enter the student " + (i + 1) + " ID: ");
			long id = myScan.nextLong();
			students[i].setID(id);

			// Get the number of tests for the student
			int num = students[i].getNumTests();
			for (int index = 0; index < num; index++) {
                
				// Prompt the user to enter each test score
				System.out.print("Please enter the exam " + (index + 1) + " score: ");
                
				int score = myScan.nextInt();

				// Validate the score to ensure it is between 0 and 100
				while (score < 0 || score > 100) {
					System.out.print("Invalid input, Please ensure the score is between 0-100");
					score = myScan.nextInt();
				}
                
				// Set the test score for the student
				students[i].setTestScore(index, score);
			}

			// Calculate the result for the student
			students[i].calculateResult();
		}

		// Display details of all students
		for (Student p : students) {
			System.out.println(p.toString());
		}
	}
}