class BubbleSort {
	private BubbleSort(){}

	public static void sort(Comparable[] arr) {
		// 外层，控制循环次数，因为两两交换，所以次数为数组长度-1
		for(int i = 0; i < arr.length-1; i++) {
			// 内层，控制每一趟排序的次数，因为每次排完被丢到末尾的就不用再管了，所以次数为length-1-i
			for(int j = 0; j < arr.length-1-i;j++) {
				// 每次都把大的丢到最后，排完之后是从小到大的
				if(arr[j] > arr[j+1])
					swap(arr,j,j+1);
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}