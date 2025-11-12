package Array;

public class Search {
	public static void main(String[] args) {
		int[] array = {5, 2, 10 ,3 , 8, 12, 1, 7};
		
		int min = array[1];
		int indexMin = 0;
		int max = array[1];
		int indexMax = 0;
		
		for(int i = 0; i < array.length;i++) {
			if(min > array[i]) {
				min = array[i];
				indexMin = i;
			}
			if(max < array[i]) {
				max = array[i];
				indexMax = i;
			}
		}
		System.out.println("最小值" + min + "索引为" + (indexMin+1) + "最大值" + max + "索引为" + (indexMax+1));
		
	}
}
