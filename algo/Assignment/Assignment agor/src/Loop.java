import java.util.Scanner;
public class Loop {
    public static void main(String[] args) {
        //The fillPascalTriangle function recursively fills each row of Pascal's Triangle.
        //The length of the array for the current row is set to the row number plus 1 (since row numbers start at 0).
        //The first and last elements of each row are set to 1.
        //Other elements in the row are calculated according to the rules of Pascal's Triangle.
        System.out.println("Please enter rows");
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();

        int[][] array = new int[rows][];
        fillPascalTriangle(array, 0, rows); // Call recursive method to fill the triangle


        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < rows - i; j++) {
                System.out.print("\t");
            }
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t\t");
            }
            System.out.println(); // New line after each row
        }
    }

    // Recursive function to fill the rows of Pascal's Triangle
    private static void fillPascalTriangle(int[][] array, int currentRow, int totalRows) {
        if (currentRow == totalRows) {
            return; // Base case for recursion - return when all rows are processed
        }

        // Initialize current row array with the appropriate length
        array[currentRow] = new int[currentRow + 1];
        array[currentRow][0] = 1; // First element of each row is 1
        array[currentRow][array[currentRow].length - 1] = 1; // Last element of each row is 1

        // Fill the middle elements of the row
        for (int i = 1; i < array[currentRow].length - 1; i++) {
            // Middle elements are sum of two numbers directly above
            array[currentRow][i] = array[currentRow - 1][i - 1] + array[currentRow - 1][i];
        }

        // Recursive call to fill the next row
        fillPascalTriangle(array, currentRow + 1, totalRows);
    }
}
