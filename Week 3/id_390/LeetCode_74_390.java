//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 示例 1: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false 
// Related Topics 数组 二分查找



//leetcode submit region begin(Prohibit modification and deletion)
// 2. 二分查找（看出一维数组） 时间O(lognm) 空间O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;
        int left = 0;
        int right = row * column - 1;
        int idx, element;
        while (left <= right) {
            idx = (left + right) / 2;
            element = matrix[idx / column][idx % column];
            if (element == target) {
                return true;
            } else if (element < target) {
                left = idx + 1;
            } else if (element > target) {
                right = idx - 1;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
