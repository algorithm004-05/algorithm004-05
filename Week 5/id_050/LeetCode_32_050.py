class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s) <= 1  :
            return 0
        res = 0
        dp = [0 for i in range(len(s))]
        for i in range(len(s) - 2, -1, -1) :
            if s[i] == '(' :        
                j = i + dp[i + 1] + 1
                if j < len(s) and s[j] == ')' :
                    dp[i] = dp[i + 1] + 2
                    if j + 1 < len(s):
                        dp[i] += dp[j + 1]
                res = max(res, dp[i])
        return res
