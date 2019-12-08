# 最长公共子序列
# 第一遍
# DP
# 法一：
class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        if not text1 or not text2:
            return 0
        # 创建二维数组
        col = len(text1)
        row = len(text2)
        dp = [[0] * col for _ in range(row)]
        # 初始化二维数组
        # 初始化第一行
        if text1[0] == text2[0]:
            dp[0][0] = 1
        for j in range(col):
            if text1[j] == text2[0] and dp[0][j-1] == 0:
                dp[0][j] = 1
            else:
                dp[0][j] = dp[0][j-1]
        # 初始化第一列
        for i in range(row):
            if text2[i] == text1[0] and dp[i-1][0] == 0:
                dp[i][0] = 1
            else:
                dp[i][0] = dp[i-1][0]
        # 填充剩余格子
        for i in range(1,row):
            for j in range(1,col):
                if text2[i] == text1[j]:
                    dp[i][j] = dp[i-1][j-1] + 1
                else:
                    dp[i][j] = max(dp[i-1][j],dp[i][j-1])
        return dp[row-1][col-1]

# 法一的优化代码：改变循环的边界，把初始化归纳到两个for循环中
class Solution(object):
    def longestCommonSubsequence(self, text1, text2):
        """
        :type text1: str
        :type text2: str
        :rtype: int
        """
        if not text1 or not text2:
            return 0
        m = len(text1)
        n = len(text2)
        dp = [[0]*(n+1) for _ in range(m+1)]
        for i in range(1,m+1):
            for j in range(1,n+1):
                if text1[i-1] == text2[j-1]:
                    dp[i][j] = 1 + dp[i-1][j-1]
                else:
                    dp[i][j] = max(dp[i-1][j],dp[i][j-1])
        return dp[m][n]

