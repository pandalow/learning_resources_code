
public class Bubble {
	public void bubble() {

		int[] arr = { 11, 2, 55, 43, 29 };

		for (int outer = arr.length - 1; outer > 0; outer--) {
			
			for (int count1 = 0; count1 < outer; count1++) {
				int count2 = count1 +1 ;
				if (arr[count1] > arr[count2]) {
					int swap = arr[count2];
					arr[count2] = arr[count1];
					arr[count1] = swap;
				}
			}
			
			for(int i= 0; i < arr.length;i++) {
			System.out.println(arr[i]);
			}
		}

	}

}
