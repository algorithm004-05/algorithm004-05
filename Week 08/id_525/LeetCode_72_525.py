class Solution(object):
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        # 将空字符也考虑进去
        row = len(word1) + 1
        col = len(word2) + 1
        dp = [[0] * col for _ in range(row)]
        for i in range(1, col):
            dp[0][i] = dp[0][i - 1] + 1
        for i in range(1, row):
            dp[i][0] = dp[i - 1][0] + 1
        for i in range(1, row):
            for j in range(1, col):
                if word1[i - 1] == word2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + 1
        return dp[-1][-1]
