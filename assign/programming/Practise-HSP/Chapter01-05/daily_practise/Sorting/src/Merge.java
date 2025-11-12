
public class Merge {

	public static void Mergesort(int[] array, int low, int high) {
		if (low >= high)
			return;

		int mid = (low + high) / 2;

		Mergesort(array, low, mid);
		Mergesort(array, mid + 1, high);
		
		int[] temp = new int[array.length];
;		Merge(array, temp, low, mid, high);

	}

	static void Merge(int[] array, int[] temp, int low, int mid, int high) {
		// 标记左半区第一个未排序的元素
		int leftLow = low;
		// 标记右半区第一个未排序的元素
		int rightLow = mid + 1;
		// 标记临时数组元素的指针
		int pos = low;

		while (leftLow <= mid && rightLow <= high) {
			if (array[leftLow] < array[rightLow]) {
				temp[pos++] = array[leftLow++];
			} else {
				temp[pos++] = array[rightLow++];
			}
		}
		while (leftLow <= mid) {
			temp[pos++] = array[leftLow++];
		}
		while (rightLow <= high) {
			temp[pos++] = array[rightLow++];
		}

		for (int i = low; i <= high; i++) {
			array[i] = temp[i];
		}
	}
}
