package com.simon.leetcode.w5.lcn64;

public class MinPathSum {
    //思路：动态规划
    //1.从终点出发
    //2.当前结点dp(i,j)=grid(i,j)+min(dp(i,j-1),dp(i-1,j))
    public int minPathSum(int[][] grid) {

        int xLen = grid.length;
        int yLen = grid[0].length;
        int[][] dp = new int[xLen][yLen];

        for (int i = xLen - 1; i >= 0; i--) {
            for (int j = yLen - 1; j >= 0; j--) {

                if (i == xLen - 1 && j != yLen - 1) {
                    //当前为网格最下行、且非终点元素
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if (j == yLen - 1 && i != xLen - 1) {
                    //当前为网格最右列、且非终点元素
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } else if (j != yLen - 1 && i != xLen - 1) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                } else {
                    //当前为终点元素
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[0][0];
    }

}
