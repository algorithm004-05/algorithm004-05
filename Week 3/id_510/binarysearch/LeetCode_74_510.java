
/**
 *
 *搜索二维矩阵
 *
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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_74_510 {

    
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,   3,  5,  7,8},{10, 11, 16, 20},{23, 30, 34, 50}};
        System.out.println(new LeetCode_74_510().searchMatrix(new int[][]{{7,8}}, 7));
       // System.out.println(new LeetCode_74_510().searchMatrix(matrix, 13));
    }

    /**
     * 
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0;
        while (x < matrix.length && matrix[x].length > 0) {
            if (target > matrix[x][0]) {
                // 当前行的第一个值小于target，到下一行查找
                x++;
                // 如果下一行存在到下一行找
                if(x < matrix.length){
                    continue;
                }
                // 说明是最后一行 回退索引
                 x--;
            } else if (target < matrix[x][0]) {
                // 当前行第一个值大于target，则回退到上一行
                // 如果不在第一行则回退到上一行 ，在第一行就不要处理了
                if(x > 0){
                    x--;
                }
            } else {
                return true;
            }

            int left = 0, right = matrix[x].length -1;
            // 二分查找
            /**
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (matrix[x][mid] > target) {
                    right = mid - 1;
                } else if (matrix[x][mid] < target) {
                    left = mid + 1;
                } else {
                    return true;
                }
            }
             */

            while (left < right) {
                int mid = left + ((right - left + 1) >> 1);
                if (matrix[x][mid] <= target) {
                    left = mid;
                } else{
                    right = mid - 1;
                } 
            }
            if(matrix[x][left] == target){
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        if(null == matrix || 0 == matrix.length){
            return false;
        }
        // 与每一行的最后一个值比较
        int x = 0, y = matrix[0].length -1;
        while(x < matrix.length && y >= 0){
            if(matrix[x][y] == target){
                return true;
            } else if (matrix[x][y] < target){
                x++;
            } else {
                y--;
            }
        }
        return false;
    }
}
