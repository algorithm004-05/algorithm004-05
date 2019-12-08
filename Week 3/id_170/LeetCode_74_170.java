class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    if (m == 0) return false;
    int n = matrix[0].length;

    // 二分查找
    int left = 0, right = m * n - 1;
    int middle, element;
    while (left <= right) {
      middle = (left + right) / 2;
      element = matrix[middle / n][middle % n];
      if (target == element) return true;
      else {
        if (target < element) right = middle - 1;
        else left = middle + 1;
      }
    }
    return false;
  }
}
