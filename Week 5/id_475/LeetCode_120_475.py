# 三角形最小路径和
# 第一遍
# DP
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        # 初始化二维数组
        dp = triangle
        # 填充剩余格子，从下往上，注意上下界
        for i in range(len(triangle)-2, -1, -1):
            for j in range(len(triangle[i])):
                dp[i][j] += min(dp[i+1][j+1],dp[i+1][j])
        return dp[0][0]