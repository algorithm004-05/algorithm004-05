// Author: liuwufang
// Date: 2019/10/20

#include <vector>
#include <string>
#include <algorithm>
using namespace std;

// https://leetcode-cn.com/problems/minimum-path-sum/
// https://leetcode.com/problems/minimum-path-sum/

// Question:
// 64. 最小路径和
// 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

// 说明：每次只能向下或者向右移动一步。

// Solution:
// 思路1: DP
// 1.子问题：a[i][j] = a[i + 1][j] + a[i][j + 1]
// 2.状态空间：dp[i][j] 到达a[i][j]路径上的数字总和
// 3.状态转移方程:
// dp[i][j] =  dp[i - 1][0] + dp[i][0]              j = 0
//          = dp[0][j - 1] + dp[0][j];              i = 0
//          =  min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j]  
// 时间复杂度：O(m x n )
// 空间复杂度：O(m x n )

int minPathSum(vector<vector<int>>& grid) {
    vector<vector<int>>& dp = grid;
    int m = grid.size();
    int n = grid[0].size(); 
    for (int i = 1; i < m; i++)
        dp[i][0] = dp[i - 1][0] + dp[i][0];
    for (int j = 1; j < n; j++)
        dp[0][j] = dp[0][j - 1] + dp[0][j];

    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
        }
    }

    return dp[m - 1][n - 1];
}

// 思路2: DP
// 使用原数组做运算
// 时间复杂度：O(N)
// 空间复杂度：O(1)
int minPathSum2(vector<vector<int>>& grid) {
    int m = grid.size();
    int n = grid[0].size(); 
    for (int i = 1; i < m; i++)
        grid[i][0] = grid[i - 1][0] + grid[i][0];
    for (int j = 1; j < n; j++)
        grid[0][j] = grid[0][j - 1] + grid[0][j];

    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            grid[i][j] = min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
        }
    }

    return grid[m - 1][n - 1];
}

void leetcode_test_064(void) {
    vector<vector<int>> grid = {
        {1,3,1},
        {1,5,1},
        {4,2,1},
    };
    minPathSum(grid); // 7
    minPathSum2(grid); // 7
}