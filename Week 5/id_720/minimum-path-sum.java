class Solution {
    public int minPathSum(int[][] grid) {

        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = grid.length - 1; i >= 0; i--) {

            for (int j = grid[0].length - 1; j >= 0; j--) {

                if(i == grid.length - 1 && j != grid[0].length - 1)
                    // 最下面一排的值，为做左面的值累加
                    dp[i][j] = grid[i][j] +  dp[i][j + 1];
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    // 最后面一排的处理，上面的值累加
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    // 在前面的计算中，可以得出的最小值
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                else
                    // 右下角初始值
                    dp[i][j] = grid[i][j];
            }
        }
        return dp[0][0];
    }
}
