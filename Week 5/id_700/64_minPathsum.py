# 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
#
# 说明：每次只能向下或者向右移动一步。

####  思路：几种走法的变形题，采用动态规划求解
####   状态  d[i][j] = d[i][j]+min(d[i-1][j]+d[i][j-i])



class Solution:
    def minPathSum(self,grid):
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if i == j == 0:
                    continue
                elif i == 0 :grid[i][j] = grid[i][j-1] +grid[i][j]
                elif j == 0 :grid[i][j] = grid[i-1][j] + grid[i][j]
                else :grid[i][j] = min(grid[i-1][j],grid[i][j-1])+grid[i][j]
        return grid[-1][-1]


### 搜集国际站大牛写法
def minPathSum(self, grid):
    m = len(grid)
    n = len(grid[0])
    for i in range(1, n):
        grid[0][i] += grid[0][i-1]
    for i in range(1, m):
        grid[i][0] += grid[i-1][0]
    for i in range(1, m):
        for j in range(1, n):
            grid[i][j] += min(grid[i-1][j], grid[i][j-1])
    return grid[-1][-1]


# O(m*n) space
def minPathSum(self, grid):
    if not grid:
        return
    r, c = len(grid), len(grid[0])
    dp = [[0 for _ in xrange(c)] for _ in xrange(r)]   ###  列表推导式
    dp[0][0] = grid[0][0]
    for i in xrange(1, r):
        dp[i][0] = dp[i - 1][0] + grid[i][0]
    for i in xrange(1, c):
        dp[0][i] = dp[0][i - 1] + grid[0][i]
    for i in xrange(1, len(grid)):
        for j in xrange(1, len(grid[0])):
            dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
    return dp[-1][-1]


def  minPathSum(self,grid):
    if not grid:
        return
    m , n = len(grid),len(grid[0])
    dp = [[ 0 for _ in range(m)] for _ in range(n)]  ### 嵌套的列表推导式 学起来
    dp[0][0] = grid[0][0]
    for i in range(1,m):
        dp[i][0] = dp[i-1][0] +grid[i][0]
    for i in range(1,n):
        dp[0][i] = dp[0][i-1]+grid[0][i]
    for i in range(1,m):
        for j in range(1,n):
            dp[i][j] = min(dp[i-1][j],dp[i][j-1])+grid[i][j]
    return dp[-1][1]

# O(2*n) space
def minPathSum2(self, grid):
    if not grid:
        return
    r, c = len(grid), len(grid[0])
    pre = cur = [0] * c
    pre[0] = grid[0][0]
    for i in xrange(1, c):
        pre[i] = pre[i - 1] + grid[0][i]
    for i in xrange(1, r):
        cur[0] = pre[0] + grid[i][0]
        for j in xrange(1, c):
            cur[j] = min(cur[j - 1], pre[j]) + grid[i][j]
        pre = cur
    return cur[-1]


# O(n) space
def minPathSum(self, grid):
    if not grid:
        return
    r, c = len(grid), len(grid[0])
    cur = [0] * c
    cur[0] = grid[0][0]
    for i in xrange(1, c):
        cur[i] = cur[i - 1] + grid[0][i]
    for i in xrange(1, r):
        cur[0] += grid[i][0]
        for j in xrange(1, c):
            cur[j] = min(cur[j - 1], cur[j]) + grid[i][j]
    return cur[-1]


# change the grid itself
def minPathSum4(self, grid):
    if not grid:
        return
    r, c = len(grid), len(grid[0])
    for i in xrange(1, c):
        grid[0][i] += grid[0][i - 1]
    for i in xrange(1, r):
        grid[i][0] += grid[i - 1][0]
    for i in xrange(1, r):
        for j in xrange(1, c):
            grid[i][j] += min(grid[i - 1][j], grid[i][j - 1])
    return grid[-1][-1]