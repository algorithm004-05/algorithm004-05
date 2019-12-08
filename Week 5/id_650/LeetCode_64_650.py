class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        dp = grid
        # 初始化边界或者在遍历时判断边界
        for i in range(len(grid)-2, -1, -1):
            dp[i][len(grid[i])-1] += dp[i+1][len(grid[i])-1]
        
        for j in range(len(grid[0])-2, -1, -1):
            dp[len(grid)-1][j] += dp[len(grid)-1][j+1]

        for i in range(len(grid)-2, -1, -1):
            for j in range(len(grid[i])-2, -1, -1):
                dp[i][j] = min(dp[i+1][j], dp[i][j+1]) + grid[i][j]
        return dp[0][0]