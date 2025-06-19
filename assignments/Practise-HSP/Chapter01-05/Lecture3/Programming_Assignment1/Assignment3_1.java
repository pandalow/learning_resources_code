import java.util.Scanner;

public class Assignment3_1 {

    public static void main(String[] args) {
        
        // Initializing a scanner to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Displaying messages to the user
        System.out.println("This program counts the number digits");
        System.out.println("in an integer by the user");
        System.out.println("Enter -1 to exit");
        
        // Variable to store the user's input
        String number; 

        // Start a loop until user enters '-1'
        do {
            System.out.print("Enter Number :");
            
            // Read the user's input
            number = scanner.nextLine(); 
            
            // Count the number of digits if the input is not '-1'
            if(!number.equals("-1")) {
                int digCounts = number.length();
                System.out.println("Number of digits in " + number + " is " + digCounts);
            }
            
        } while (!number.equals("-1")); // End loop when user enters '-1'
        
        // Notify the user that the program has ended
        System.out.println("Program Terminated");
        
        // Close the scanner to release the resources
        scanner.close();
    }
}