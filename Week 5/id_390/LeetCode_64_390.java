//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[j] += grid[i][j];
                } else if (i == 0) {
                    dp[j] = grid[i][j] + dp[j - 1];
                } else {
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);// 比较是从上还是从左边走
                }
            }
        }
        return dp[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
