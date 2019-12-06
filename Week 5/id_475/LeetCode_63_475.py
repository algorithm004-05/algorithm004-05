# LeetCode 63 不同路径
# 第一遍
# DP：自底向上
class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        # 特殊情况！！
        if obstacleGrid[0][0] == 1:
            return 0
        # 创建dp数组
        row = len(obstacleGrid)
        col = len(obstacleGrid[0])
        dp = [[0] * col for _ in range(row)]
        # 创建初始值
        dp[0][0] = 1
        for j in range(1,col):  # 创建第一行初始值
            if obstacleGrid[0][j] == 0:
                dp[0][j] = dp[0][j-1]
        for i in range(1,row):  # 同理创建第一列初始值
            if obstacleGrid[i][0] == 0:
                dp[i][0] = dp[i-1][0]
        # 填充余下格子
        for i in range(1,row):
            for j in range(1,col):
                if obstacleGrid[i][j] == 0:
                    dp[i][j] = dp[i][j-1] + dp[i-1][j]
        return dp[-1][-1]