import java.util.Scanner;

public class Recursion {
    public static void main(String[] args) {
        System.out.println("Please enter rows");
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        scan.close();

        printUseRecursion(rows);
    }

//The printUseRecursion method is responsible for printing Pascal's Triangle. It does this by calculating each number in the triangle using the combination formula C(n, k), which is equal to factorial(n) / (factorial(n-k) * factorial(k)).
    private static void printUseRecursion(int n) {
        for (int i = 0; i < n; i++) {
            // Print leading spaces for each row to form a pyramid shape
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("  "); // Two spaces for alignment
            }
            // Calculate and print each number in the row
            for (int k = 0; k <= i; k++) {
                // Print each number separated by spaces
                System.out.print(factorial(i) / (factorial(i - k) * factorial(k)) + "   ");
            }
            System.out.println();
        }
    }

//The factorial method calculates the factorial of a given number using recursion. It has a base case for 0 (where the factorial is 1) and a recursive case that multiplies the number by the factorial of the number minus one.
    public static int factorial(int i) {
        if (i == 0) {
            return 1; // Base case: factorial of 0 is 1
        }
        // Recursive case: factorial of i is i times factorial of i-1
        return i * factorial(i - 1);
    }
}