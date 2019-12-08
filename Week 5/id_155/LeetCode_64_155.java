class Solution {
   public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] dp = new int[col];
        
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 && j == col - 1) {
                    dp[j] = grid[i][j];
                } else if (i == row - 1) {
                    dp[j] = grid[i][j] + dp[j + 1];
                } else if (j == col - 1) {
                    dp[j] = grid[i][j] + dp[j];
                } else {
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                }
            }
        }

        return dp[0];
    }
}