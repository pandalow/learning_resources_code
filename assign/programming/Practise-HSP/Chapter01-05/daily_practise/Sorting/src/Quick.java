
public class Quick {
	//数组中的传参是引用对象地址,所以传参后会改变数组排序
	public void quickSort(int[] array, int low, int high) {

		if (low < high) {
			int pivot = partion(array, low, high);
			quickSort(array, low, pivot - 1);
			quickSort(array, pivot + 1, high);
		}
	}

	public static int partion(int[] array, int low, int high) {

		int pivot = array[low];
		int i = high;
		int j = low;

		// 这个循环条件保证 i 和 j 会在数组的两端开始，向中间移动，并且在适当的时候进行交换。
		// 当 i 和 low 相遇，即 i 已经移动到数组左侧或者 i 和 j 相遇或交叉时，循环结束
		while (low < i) {
			// 寻找大于pivot的值,且不会超过索引边界
			do {
				j++;
			} while (j <= high && pivot >= array[j]);
			// 寻找小于pivot的值,且不会超过索引边界
			do {
				i--;
			} while (i >= low && pivot <= array[i]);

			// 当 j < i 时，表示找到了一对需要交换的元素：j 指向的元素比 pivot 大，而 i 指向的元素比 pivot 小。交换这两个元素有助于将小于
			// pivot 的元素移动到左侧，大于 pivot 的元素移动到右侧。
			// 如果 j 和 i 相遇或者 j 超过 i（即 j >= i），则表示当前的 pivot 两侧已正确划分：左侧所有元素都小于 pivot，右侧所有元素都大于
			// pivot。此时，不应再进行交换，因为这可能会破坏已经完成的正确划分。
			if (j < i) {
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
			}
		}

		int temp = array[low];
		array[low] = array[i];
		array[i] = temp;

		return i;

	}
}
