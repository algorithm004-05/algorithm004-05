/**
*	由小到大的选择排序
*/
public class SelectionSort {
	private SelectionSort() {}

	private static void sort(int[] arr) {
		// 两重循环，外层i扫描数组所有元素，内层 j=i+1为了扫描得到从i+1开始的最小值的索引
		for(int i = 0 ; i < arr.length; i++) {
			int minIndex = i;
			for(int j = i+1; j < arr.length; j++) {
				if(arr[j] < arr[minIndex]) 
					minIndex = j;
				swap(arr, i, minIndex);
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}