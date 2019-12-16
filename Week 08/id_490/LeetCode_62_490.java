/**
 * 题目名称：unique-paths 不同路径
 * 题目链接：https://leetcode-cn.com/problems/unique-paths/
 */
class Solution {
    public int uniquePaths(int m, int n) {
        // 二维DP
        int[][] dp = new int[n][m];
        // 初始化第一行和第一列的值为1
        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[j][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j]= dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[n - 1][m - 1];
    }

    // 一维DP
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        // 初始化第一行的值为1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}