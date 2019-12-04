/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // convert to list
        final int h = matrix.length;
        if (h < 1) {
            return false;
        }
        final int w = matrix[0].length;
        if (w < 1) {
            return false;
        }
        final int len = w * h;
        // search
        int start = 0, end = len - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int midValue = matrix[mid / w][mid % w];
            if (midValue == target) {
                return true;
            }
            
            if (target < midValue) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}

