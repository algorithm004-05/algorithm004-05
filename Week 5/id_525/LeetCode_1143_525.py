class Solution(object):
    def longestCommonSubsequence(self, text1, text2):
        """
        :type text1: str
        :type text2: str
        :rtype: int
        """
        row, col = len(text1), len(text2)
        dp = [[0 for _ in range(col + 1)] for i in range(row + 1)]
        for i in range(1, row + 1):
            for j in range(1, col + 1):
                if text1[i - 1] == text2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1] + 1
                else:
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
        return dp[row][col]
