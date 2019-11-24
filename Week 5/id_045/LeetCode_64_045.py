# @author:leacoder
# @des:  动态规划 最小路径和


'''
二维动态规划：
a、重复子问题
result[y][x] = subresult + grid[y][x]
由于 每次只能向下或者向右移动一步 ，那么 subresult 就为 来自 当前位置的 上 和 左 位置的最小值

b、状态定义
dp[y][x] 位置为 x , y (x 横坐标， y纵坐标) 的最小路径和

c、dp 方程
dp[i][j] = min(dp[i][j-1],dp[i-1][j]) + grid[i][j]
这里 注意边界判断 也就是 i j 为 0 时的处理

'''

class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        max_y = len(grid)
        max_x = len(grid[0])
        dp = [[0 for _ in range(max_x)] for _ in range(max_y)]

        for i in range(max_y):
            for j in range(max_x):
                if i == 0 and j == 0: 
                    continue # grid[i][j] = grid[i][j]
                elif j == 0:
                    dp[i][j] = dp[i-1][j] + grid[i][j]
                elif i == 0:
                    dp[i][j] = dp[i][j-1] + grid[i][j]
                else:
                    dp[i][j] = min(dp[i][j-1],dp[i-1][j]) + grid[i][j]
        return dp[max_y-1][max_x-1]
		

'''
可以不用额外存储空间，直接在原数组上存储dp

'''

class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        max_y = len(grid)
        max_x = len(grid[0])
        for i in range(max_y):
            for j in range(max_x):
                if i == 0 and j == 0: 
                    continue
                elif j == 0:
                    grid[i][j] = grid[i-1][j] + grid[i][j]
                elif i == 0:
                    grid[i][j] = grid[i][j-1] + grid[i][j]
                else:
                    grid[i][j] = min(grid[i][j-1],grid[i-1][j]) + grid[i][j]
        return grid[max_y-1][max_x-1]