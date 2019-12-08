/**
 * https://leetcode-cn.com/problems/minimum-path-sum/submissions/
 */
public class LeetCode_64_100 {

    /**
     * 可得出dp方程为：sub_min(i, j) = Math.min(sub_min(i - 1, j), sub_min(i, j - 1)) + grid[i][j]
     * 需要主意的是在i或者是j等于0的情况下累计前值即可
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(m*n)
     */
    public int minPathSum(int[][] grid) {
  
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}