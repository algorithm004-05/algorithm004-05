//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
//每行中的整数从左到右按升序排列。
//每行的第一个整数大于前一行的最后一个整数。
//示例 1:
//
//输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
//示例 2:
//
//输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/search-a-2d-matrix
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class LeetCode_74_295 {
    // 将 m * n 矩阵看作一个有序的一维数组，row = mid // n ， col = mid % n
    // 之后进行二分查找即可

    // 时间复杂度 O(logMN)
    // 空间复杂度 O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            int midElement = matrix[mid / n][mid % n];
            if (midElement == target) return true;
            if (target > midElement)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
}
