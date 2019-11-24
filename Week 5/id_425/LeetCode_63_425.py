#
# @lc app=leetcode.cn id=63 lang=python3
#
# [63] 不同路径 II
#
# https://leetcode-cn.com/problems/unique-paths-ii/description/
#
# algorithms
# Medium (31.79%)
# Likes:    177
# Dislikes: 0
# Total Accepted:    28.3K
# Total Submissions: 88.8K
# Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
#
# 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
# 
# 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
# 
# 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
# 
# 
# 
# 网格中的障碍物和空位置分别用 1 和 0 来表示。
# 
# 说明：m 和 n 的值均不超过 100。
# 
# 示例 1:
# 
# 输入:
# [
# [0,0,0],
# [0,1,0],
# [0,0,0]
# ]
# 输出: 2
# 解释:
# 3x3 网格的正中间有一个障碍物。
# 从左上角到右下角一共有 2 条不同的路径：
# 1. 向右 -> 向右 -> 向下 -> 向下
# 2. 向下 -> 向下 -> 向右 -> 向右
# 1 递归，带数组递归，自顶向下
# 2 动态规划，数据，递推公式，循环，自底向上
#

# @lc code=start
class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        dp = [[0]*n for _ in range(m)]
        def opt (m,n,dp):
            if obstacleGrid[m-1][n-1] ==1:
                dp[m-1][n-1] = 0
            elif m==1 or n==1:
                dp[m-1][n-1] = 1
            else:
                dp[m-1][n-1] = opt(m-1,n,dp)+opt(m,n-1,dp)
            return dp[m-1][n-1]
        opt (m,n,dp)
        return dp[m-1][n-1]

        

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        # m = len(obstacleGrid)
        # n = len(obstacleGrid[0])
        # #print('m:',m,'n:',n)
        # dp = [[0]*n for _ in range(m)]

        # def opt(i,j,dp):
        #     if i > m-1 or j >n-1:
        #         #print('1')
        #         return 0 
        #     elif obstacleGrid[i][j] == 1:
        #         #print('2')
        #         return 0
        #     elif i == m-1 and j==n-1:
        #         #print('3')
        #         dp[i][j] = 1
        #     else:
        #         #print('4')
        #         dp[i][j] = opt(i+1,j,dp)+opt(i,j+1,dp)
        #     return dp[i][j]
        # opt(0,0,dp)
        # return dp[0][0]

# @lc code=end

