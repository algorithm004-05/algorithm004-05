/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 *
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (49.00%)
 * Likes:    1773
 * Dislikes: 45
 * Total Accepted:    278.5K
 * Total Submissions: 563K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * 
 * 
 */

// @lc code=start

class Solution {
    public int minPathSum(int[][] grid) {

        int [][] dp = new int[grid.length][grid[0].length];

        for (int i = grid.length -1 ; i >= 0; i--) {
            for (int j = grid[i].length - 1; j >= 0; j--){

                if (i == grid.length - 1 && j != grid[0].length -1) {
                    dp[i][j] = dp[i][j + 1] + grid[i][j];
                } else if (i != grid.length - 1 && j == grid[0].length -1) {
                    dp[i][j] = dp[i + 1][j] + grid[i][j];
                } else if (i != grid.length -1 && j != grid[0].length -1) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j],dp[i][j + 1]);
                } else {
                    dp[i][j] = grid[i][j];
                }

            }
        }

        return dp[0][0];
    }
}
// @lc code=end

