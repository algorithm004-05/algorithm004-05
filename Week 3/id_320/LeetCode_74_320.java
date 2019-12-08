package lesson.week.three;

/**
 * Created by liangwj20 on 2019/11/03 09:01
 * Description: 搜索二维矩阵
 */
public class LeetCode_74_320 {

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,50}}, 10));
    }
    private static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        int pivot, pivotE;
        while (left <= right) {
            pivot = (left + right) / 2;
            pivotE = matrix[pivot / n][pivot % n];
            if (pivotE == target) {
                return true;
            } else if(pivotE < target) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return false;
    }


}
