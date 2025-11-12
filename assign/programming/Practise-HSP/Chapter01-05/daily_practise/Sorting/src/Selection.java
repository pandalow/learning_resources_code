
public class Selection {

	public void selection() {
		int[] arr = { 221, 34, 215, 349, 101 };

		for (int outer = 0; outer < arr.length; outer++) {
			// searching min values;
			int min = outer; // Assumed array[outer] is minium values
			
			// searching after array[outer] values, then locate the values to [min]
			for (int inner = outer+1; inner < arr.length; inner++) {
				if (arr[min] > arr[inner]) {
					min = inner;
				}
			}
			// swap the values
			int temp = arr[outer];
			arr[outer] = arr[min];
			arr[min] = temp;
			
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
