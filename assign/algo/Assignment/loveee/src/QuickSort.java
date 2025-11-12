import java.util.Scanner;
public class QuickSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the length of array");
        int length = scan.nextInt();
        int[] list = new int[length];

        for(int i = 0; i< list.length; i++){
            System.out.println("Enter the No." + i + " Integer number");
            int num = scan.nextInt();
            list[i] = num;
        }

        quickSort(list,0,list.length-1);

        for(int i = 0; i< list.length;i++){
            System.out.println(list[i]);
        }
    }

    public static void quickSort(int[] list,int low, int high) {

        if (low < high) {
            int pivot = partition(list, low, high);
            quickSort(list,low, pivot - 1);
            quickSort(list,pivot + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (i <= high && array[i] <= pivot) {
                i++;
            }
            while (j >= low && array[j] > pivot) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[low];
        array[low] = array[j];
        array[j] = temp;
        return j;
    }
}
