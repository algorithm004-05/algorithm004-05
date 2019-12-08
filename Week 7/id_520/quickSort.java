class quickSort {
	private quickSort() {}

	public static void quicksort(int[] array, int begin, int end) {
		if(end <= begin) return;
		int pivot = partition(array, begin, end);
		quicksort(array, begin, pivot-1);
		quicksort(array, pivot+1, end);
	}

	public int partition(int[] a, int begin, int end){
		int pivot = end, counter = begin;
		for(int i = begin, i < end; i++) {
			if(a[i] < a[pivot]) {
				swap(a,counter,i);
				++counter;
			}
		}	
		swap(a,pivot, counter);
		return counter;
	}

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}