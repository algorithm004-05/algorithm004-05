/*
 * @lc app=leetcode.cn id=64 lang=cpp
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        for(int i = 1; i < grid.size(); i++)
            grid[i][0] += grid[i - 1][0]; 
        for(int j = 1; j < grid[0].size(); j++)
            grid[0][j] += grid[0][j - 1]; 
        for(int i = 1; i < grid.size(); i++){
            for(int j = 1; j < grid[0].size(); j++){
            grid[i][j] += min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[grid.size()-1][grid[0].size()-1];
        
    }
};
// @lc code=end

