class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        dp 为当前走过的最小路径和
        dp[i][j] = min(dp[i-1][j],dp[i][j-1])+grid[i][j]
        当i为0时，只能往下走
        dp[i][j] = dp[i][j-1] + grid[i][j]
        当j为0时，只能往右走
        dp[i][j] = dp[i-1][j] +grid[i][j]
        当i，j为0时，说明是起点
        dp[i][j] = grid[i][j]
        """
        if not grid: return 0
        dp = [[0 for _ in range(len(grid[0]))] for _ in range(len(grid))]
        for i in range(len(dp)):
            for j in range(len(dp[0])):
                if i == j == 0:
                    dp[i][j] = grid[i][j]
                elif i == 0:
                    dp[i][j] = dp[i][j - 1] + grid[i][j]
                elif j == 0:
                    dp[i][j] = dp[i - 1][j] + grid[i][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
        return dp[-1][-1]
