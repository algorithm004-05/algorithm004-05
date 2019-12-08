class Solution:
    def longestValidParentheses(self, s: str) -> int:
        """
        DP思路：
        1. 分治子问题
            a. s[i]='('时，肯定是不有效的，不处理
            b. s[i]=')'且s[i-1]='('时，dp[i]=dp[i-2]+2
            c. s[i]=')'且s[i-1]=')'时，如果dp[i-dp[i-1]-1]='('
            dp[i] = dp[i-1] + dp[i-dp[i-1]-1] + 2
            其中dp[i-dp[i-1]-2]是s[i]这个')'对应的'('前面的有效值
        2. 状态数组 dp[i]
        3. dp方程就是1中的两个分支
        """
        res = 0
        dp = [0 for i in range(len(s))]
        for i in range(1, len(s)):
            if s[i] == ')':
                if s[i-1] == '(':
                    dp[i] = (dp[i-2] if i>=2 else 0) + 2
                elif i-dp[i-1]-1 >=0 and s[i-dp[i-1]-1] == '(':
                    dp[i] = dp[i-1] + (dp[i-dp[i-1]-2] if i-dp[i-1]-2>=0 else 0) + 2
                res = max(dp[i], res)
        return res