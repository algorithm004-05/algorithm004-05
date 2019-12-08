class mergeSort{

	public static void mergesort(int[] arr, int left, int right) {
		if (right <= left) return;

		int mid = (left+right) >> 1;

		mergesort(arr, left, mid);
		mergesort(arr,mid+1,right);
		merge(arr,left,mid,right);
	}

	public static void merge(int[] arr, int left, int mid, int right) {
		int temp = new int[right-left+1];
		int i = left, j = mid + 1, k = 0;

		while(i <= mid && j <= right) {
			temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
		}
	 	while(i <= mid) temp[k++] = arr[i++];
	 	while(j <= right) temp[k++] = arr[j++];

	 	for(int p = 0 ; p < arr.length; ++p) {
	 		arr[left + p] = temp[p];
	 	}

	}
}