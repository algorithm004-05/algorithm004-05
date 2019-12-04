class Solution {
    public:
    int minPathSum(vector<vector<int>>& grid)
    {
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n, grid[0][0]));  //新建一个bp二维数组，把原来数组的[0][0]元素赋值
        for (int i = 1; i < m; ++i) {                           //最左列元素处理
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {  //最右列元素处理
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];  //返回dp中的最后一个元素（size() - 1)，size的大小和下标相差一位
    }
};