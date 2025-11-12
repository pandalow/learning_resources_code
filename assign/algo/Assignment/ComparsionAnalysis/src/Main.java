import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
public class Main{
    static int length = 1000;
    static final int max_length = 300000;
    static int[] list = new int[max_length];

    public static void main(String[] args) {
        for (length = 1000; length <= max_length;) {
            System.out.println("\nLength\t: " + length);

            read();
            long startTime = System.nanoTime();
            selectionSort();
            long endTime = System.nanoTime();
            System.out.println("Selection Sort\t: " + (endTime - startTime) / 1e9 + " sec");

            read();
            startTime = System.nanoTime();
            quickSort(0, length - 1);
            endTime = System.nanoTime();
            System.out.println("Quick Sort\t: " + (endTime - startTime) / 1e9 + " sec");


            switch (length) {
                case 1000:
                    length = 5000;
                    break;
                case 5000:
                    length = 10000;
                    break;
                case 10000:
                    length = 50000;
                    break;
                case 50000:
                    length = 100000;
                    break;
                case 100000:
                    length = 200000;
                    break;
                case 200000:
                    length = 300000;
                    break;
                case 300000:
                    length = 300001;
                    break;
            }
        }
    }
    public static void read() {
        try (FileInputStream fis = new FileInputStream("random.dat");
             FileChannel channel = fis.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES * length);
            channel.read(buffer);
            buffer.flip();
            for (int i = 0; i < length; i++) {
                list[i] = buffer.getInt();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void quickSort(int low, int high) {

        if (low < high) {
            int pivot = partition(list, low, high);
            quickSort(low, pivot - 1);
            quickSort(pivot + 1, high);
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

    private static void selectionSort() {
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (list[j] < list[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = list[minIndex];
            list[minIndex] = list[i];
            list[i] = temp;
        }
    }// Other methods (read, bubbleSort, insertionSort, partition, quickSort) go here
}