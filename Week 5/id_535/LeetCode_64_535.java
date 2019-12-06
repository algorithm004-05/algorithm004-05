/**
 * created by lchen on 2019/11/17
 */
public class LeetCode_64_535 {

    public static void main(String[] args) {
        LeetCode_64_535 l = new LeetCode_64_535();
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(l.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[grid.length - 1][grid[0].length - 1] = grid[grid.length - 1][grid[0].length - 1];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if (j == grid[0].length - 1 && i != grid.length - 1) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } else if (i != grid.length - 1 && j != grid[0].length - 1) {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
                } else {
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[0][0];
    }


}
