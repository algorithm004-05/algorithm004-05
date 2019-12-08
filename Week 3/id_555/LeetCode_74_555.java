package lsn11.binary_search;

/**
 * 74. 搜索二维矩阵
 *
 */
public class LeetCode_74_555 {

	public static void main(String[] args) {

		LeetCode_74_555 leetcode = new LeetCode_74_555();

		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };

		int target = 3;

		System.out.println(leetcode.searchMatrix(matrix, target));

	}

	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		if (m == 0)
			return false;
		int n = matrix[0].length;

		// 二分查找
		int left = 0, right = m * n - 1;
		int pivotIdx, pivotElement;
		while (left <= right) {
			pivotIdx = (left + right) / 2;
			pivotElement = matrix[pivotIdx / n][pivotIdx % n];
			if (target == pivotElement)
				return true;
			else {
				if (target < pivotElement)
					right = pivotIdx - 1;
				else
					left = pivotIdx + 1;
			}
		}
		return false;
	}

}
