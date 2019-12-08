package xyz.isok.algorithm.leetcode.medium;

public class No64MinimumPathSum {

    public static void main(String[] args) {
//        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        int[][] grid = {{1, 2}, {1, 1}};

        No64MinimumPathSum minimumPathSum = new No64MinimumPathSum();
        System.out.println(minimumPathSum.minPathSum(grid));

    }

    public int minPathSum(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int[][] dp = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                dp[i][j] = i == 0 ? (j == 0 ? grid[i][j] : dp[i][j - 1] + grid[i][j]) : (j == 0 ? dp[i - 1][j] + grid[i][j] : Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]));
            }
        }
        return dp[height - 1][width - 1];
    }

}
