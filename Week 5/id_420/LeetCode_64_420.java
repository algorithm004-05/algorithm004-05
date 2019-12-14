package geekbang.myleetcode.week05;

/**
 * @author: jimmy.wong
 * @date: 2019-11-17 22:19
 */
public class LeetCode_64_420 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        Solution solution = new LeetCode_64_420().new Solution();
        int result = solution.minPathSum(grid);
        System.out.println("minPathSum==>" + result);
    }


    class Solution {
        public int minPathSum(int[][] grid) {
            int[][] dp = new int[grid.length][grid[0].length];
            int row = grid.length;
            int col = grid[0].length;
            dp[row - 1][col - 1] = grid[row - 1][col - 1];
            for (int i = row - 2; i >= 0; i--) {
                dp[i][col - 1] = dp[i + 1][col - 1] + grid[i][col - 1];
            }
            for (int j = col - 2; j >= 0; j--) {
                dp[row - 1][j] = dp[row - 1][j + 1] + grid[row - 1][j];
            }
            for (int i = row - 2; i >= 0; i--) {
                for (int j = col - 2; j >= 0; j--) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
            }
            return dp[0][0];
        }
    }
}
