/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */

// @lc code=start
class Solution {
    //subProblems: f(i,j) = min(f(i-1,j),f(i,j-1)) + grid[i][j]
    //dp[i][j]: min path to [i][j]
    //dp[i][j] = min(dp[i-1][j], min(dp[i][j-1])) + grid[i][j]
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i ==0 && j ==0){
                    dp[0][0] = grid[0][0];
                    continue;
                }
                if(i==0){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }else if(j==0){
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }else{
                    dp[i][j] = ((dp[i-1][j]>dp[i][j-1]?dp[i][j-1]:dp[i-1][j])+ grid[i][j]);
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
// @lc code=end

