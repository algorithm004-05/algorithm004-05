class InsertSort {

	// 不产生实例
	private InsertSort() {}

	public static void sort(Comparable[] arr) {
		for(int i = 0; i < arr.length; i++) {

			// 寻找元素arr[i]适合插入的元素，这里是选择出更小的元素

			// 写法1
			// for(int j = i; j > 0; j--) {
			// 	if(arr[j].compareTo(arr[j-1]) < 0)
			// 		swap(arr, j, j-1);
			// 	else
			// 		break;
			// }

			//写法2
			for(int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0;j--)
				swap(arr, j, j-1);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

