/**
 * Created by panda on 2019/11/17.
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_64_430 {
    class Solution {
        public int minPathSum(int[][] grid) {
            if (grid.length == 0) {
                return 0;
            }
            int m = grid.length;
            int n = grid[0].length;
            // 终点为i（列号）的最小路径和
            // 因为永远只需要上面和左面的元素，二维可以简化为一维
            int[] dp = new int[n];
            // 初始化dp
            dp[0] = grid[0][0];
            for (int i = 1; i < n; i++) {
                // 第一行对于i,i-1是必经之路
                dp[i] = dp[i - 1] + grid[0][i];
            }
            // 行号从1开始
            for (int i = 1; i < m; i++) {
                // 对于i行第一个数，i-1行第一个数是必经之路
                dp[0] = dp[0] + grid[i][0];
                // 列号从1开始
                for (int j = 1; j < n; j++) {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
                }
            }
            return dp[n - 1];
        }
    }
}
