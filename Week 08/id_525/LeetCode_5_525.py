class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        n = len(s)
        res = ''
        dp = [[False] * n for _ in range(n)]
        for l in range(n - 1, -1, -1):
            for r in range(l, n):
                dp[l][r] = s[l] == s[r] and (r - l < 2 or dp[l + 1][r - 1])
                if dp[l][r] and r - l + 1 > len(res):
                    res = s[l:r + 1]
        return res
