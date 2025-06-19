import java.util.Scanner;

public class Binomial {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // Read the values for n and k
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        // Initialize values for the numerator and denominator
        int number = 1;
        int knumber = 1;

        // Ensure conditions are met before calculating
        if (n >= 0 && k >= 0 && n >= k) {
            // Calculate the numerator
            for (int i = 0; i < k; i++) {
                number *= (n - i);
            }

            // Calculate the denominator
            for (int i = 1; i <= k; i++) {
                knumber *= i;
            }
        }

        // Compute the result and print
        double sum = (double) number / knumber;
        System.out.println(sum);
    }
}