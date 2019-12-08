# 最小路径和
# DP
# 自己写的
class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if not grid:
            return 0
        m = len(grid)
        n = len(grid[0])
        # 创建数组
        dp = [ [0] * n for _ in range(m)]
        # 初始化数组
        dp[-1][-1] = grid[-1][-1]
        # 初始化数组最后一行
        for j in range(n-2,-1,-1):
            dp[-1][j] = dp[-1][j+1] + grid[-1][j]
        # 初始化数组最后一列
        for i in range(m-2,-1,-1):
            dp[i][-1] = dp[i+1][-1] + grid[i][-1]
        # 填充剩余位置
        for i in range(m-2,-1,-1):
            for j in range(n-2,-1,-1):
                dp[i][j] = min(dp[i][j+1],dp[i+1][j]) + grid[i][j]
        return dp[0][0]

# 别人写的
# O(m*n) space
def minPathSum(self, grid):
    if not grid:
        return 
    r, c = len(grid), len(grid[0])
    dp = [[0 for _ in xrange(c)] for _ in xrange(r)]
    dp[0][0] = grid[0][0]
    for i in xrange(1, r):
        dp[i][0] = dp[i-1][0] + grid[i][0]
    for i in xrange(1, c):
        dp[0][i] = dp[0][i-1] + grid[0][i]
    for i in xrange(1, len(grid)):
        for j in xrange(1, len(grid[0])):
            dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
    return dp[-1][-1]

# O(2*n) space
def minPathSum2(self, grid):
    if not grid:
        return 
    r, c = len(grid), len(grid[0])
    pre = cur = [0] * c
    pre[0] = grid[0][0] 
    for i in xrange(1, c):
        pre[i] = pre[i-1] + grid[0][i]
    for i in xrange(1, r):
        cur[0] = pre[0] + grid[i][0]
        for j in xrange(1, c):
            cur[j] = min(cur[j-1], pre[j]) + grid[i][j]
        pre = cur
    return cur[-1]

