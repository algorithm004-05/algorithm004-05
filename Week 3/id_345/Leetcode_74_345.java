package xyz.isok.algorithm.leetcode.medium;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 *
 */
public class No74SearchA2dMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 12;
        System.out.println(new No74SearchA2dMatrix().searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int top = 0, left = 0, bottom = matrix.length - 1, right = matrix[0].length - 1;
        if (target > matrix[bottom][right] || target < matrix[0][0]){
            return false;
        }
        int rowIdx = 0;
        while (top <= bottom){
            int mid = top + (bottom - top)/2;
            if (target >= matrix[top][0] && target <= matrix[top][right]){
                rowIdx = top;
                break;
            }
            if (target >= matrix[mid][0] && target <= matrix[mid][right]){
                rowIdx = mid;
                break;
            }
            if (target >= matrix[bottom][0] && target <= matrix[bottom][right]){
                rowIdx = bottom;
                break;
            }

            if (target > matrix[mid][right]){
                top = mid + 1;
            }else {
                bottom = mid - 1;
            }
        }
        while (left <= right){
            int colIdx = left + (right - left)/2;
            if (matrix[rowIdx][left] == target || matrix[rowIdx][colIdx] == target || matrix[rowIdx][right] == target){
                return true;
            }
            if (target > matrix[rowIdx][colIdx]){
                left = colIdx + 1;
            }else {
                right = colIdx - 1;
            }
        }
        return false;
    }

}
