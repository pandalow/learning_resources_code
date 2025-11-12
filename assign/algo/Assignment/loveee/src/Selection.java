import java.util.Scanner;

public class Selection {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the length of array");
        int length = scan.nextInt();
        int[] list = new int[length];

        for (int i = 0; i < list.length; i++) {
            System.out.println("Enter the No." + i + " Integer number");
            int num = scan.nextInt();
            list[i] = num;
        }
        int minIndex;
        for (int i = 0; i < list.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (list[j] < list[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = list[minIndex];
            list[minIndex] = list[i];
            list[i] = temp;
        }
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }
}
