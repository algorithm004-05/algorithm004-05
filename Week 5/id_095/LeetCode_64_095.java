/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 *
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (49.48%)
 * Likes:    1775
 * Dislikes: 45
 * Total Accepted:    278.7K
 * Total Submissions: 563.3K
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
        int m = grid.length;// row
	    int n = grid[0].length; // column
	    for (int i = 0; i < m; i++) {
		    for (int j = 0; j < n; j++) {
			    if (i == 0 && j != 0) {
				    grid[i][j] = grid[i][j] + grid[i][j - 1];
			    } else if (i != 0 && j == 0) {
				    grid[i][j] = grid[i][j] + grid[i - 1][j];
			    } else if (i == 0 && j == 0) {
				    grid[i][j] = grid[i][j];
			    } else {
				    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j])
						+ grid[i][j];
			}
		}
	}
	return grid[m - 1][n - 1];
        
    }
}
// @lc code=end

