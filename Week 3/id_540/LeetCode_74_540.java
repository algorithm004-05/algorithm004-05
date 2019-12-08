package com.company;

public class LeetCode_74_540 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0 || target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        }

        int size = matrix.length * matrix[0].length;
        int start = 0;
        int end = size - 1;

        if (matrix[0][0] == target || matrix[matrix.length - 1][matrix[0].length - 1] == target) {
            return true;
        }

        while ((end - start) > 1) {
            int mid = (start + end) / 2;
            if (matrix[mid / matrix[0].length][mid % matrix[0].length] == target) {
                return true;
            } else if (matrix[mid / matrix[0].length][mid % matrix[0].length] > target){
                end = mid;
            } else {
                start = mid;
            }
        }

        return false;
    }
}
