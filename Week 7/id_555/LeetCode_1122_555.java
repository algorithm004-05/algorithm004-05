package lsn18_sort;

/**
 * 1122. 数组的相对排序
 * 
 * https://leetcode-cn.com/problems/relative-sort-array/
 */
public class LeetCode_1122_555 {

	public static void main(String[] args) {
		LeetCode_1122_555 leetcode = new LeetCode_1122_555();
		int[] arr1 = { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 };
		int[] arr2 = { 2, 1, 4, 3, 9, 6 };
		leetcode.relativeSortArray(arr1, arr2);
	}

	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		// 由于arr1的可能取值为0-1000，共1001个取值，不算一个很大的取值范围，所以可以利用桶式排序
		int[] bucket = new int[1001];
		// 计数每个桶有多少个数，也就是每个值在数组中有几个
		for (int num : arr1) {
			bucket[num]++;
		}
		// 由于重新排序不会改变数组的长度，所以可以利用原数组，可以节省空间复杂度
		int i = 0;
		// 由于排序是按照相对顺序进行排序，所以，首先根据arr2中的桶的顺序，依次从对应的桶中取数到arr1中
		// 并注意，每拿出一个数，需要将对桶中的数的个数进行-1操作
		for (int num : arr2) {
			while (bucket[num]-- > 0) {
				arr1[i++] = num;
			}
		}
		// 未在arr2中的桶中的数，按照桶号升序进行输出，所以进行二次遍历
		for (int j = 0; j < 1001; ++j) {
			while (bucket[j]-- > 0) {
				arr1[i++] = j;
			}
		}
		return arr1;
	}

	public int[] relativeSortArray2(int[] arr1, int[] arr2) {
		int[] m = new int[1001];

		int[] ref = new int[arr1.length];

		for (int i = 0; i < arr1.length; i++) {
			m[arr1[i]]++;
		}

		int cnt = 0;
		for (int i = 0; i < arr2.length; i++) {
			while (m[arr2[i]] > 0) {
				ref[cnt++] = arr2[i];
				m[arr2[i]]--;
			}
		}

		for (int i = 0; i < 1001; i++) {
			while (m[i] > 0) {
				ref[cnt++] = i;
				m[i]--;
			}
		}
		return ref;
	}

}
