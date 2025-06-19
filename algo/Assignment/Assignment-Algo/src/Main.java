import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

// The first row has 1 element, and the i-th row has i elements.
// Starting from the third line, for the values of the non-first element and the last element, the following rules are followed:
// array[i][j]= array[i-1][j] + array[i-1][j-1];
        System.out.println("Please enter rows");
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int[][] array = new int[rows][];
        //Traverse array each element;
        for(int i = 0; i< array.length; i++){

            //Make space for each row of a one-dimensional array
            array[i] = new int[i+1];

            //Assign a value to each row of a one-dimensional array
            for(int j = 0;j< array[i].length;j++){
                // The first row has 1 element, and the i-th row has i elements.
               if(j == 0 || j == array[i].length-1){
                    array[i][j] = 1;
                }else{
                   array[i][j]= array[i-1][j] + array[i-1][j-1];
                }
            }
        }
        //Print the array
        for(int i = 0; i < array.length; i++){
            //Added an inner loop to insert spaces before each line of numbers is printed
            for (int j = 0; j < array.length - i; j++) {
                System.out.print("\t");
            }

            for(int j = 0; j< array[i].length; j++){
                System.out.print(array[i][j] + "\t\t");
            }
            System.out.println("");
        }
    }
}
