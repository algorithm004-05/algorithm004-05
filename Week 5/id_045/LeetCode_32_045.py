# @author:leacoder
# @des:  动态规划 最长有效括号

class Solution:
    def longestValidParentheses(self, s: str) -> int:
        maxans = 0
        dp = [0] * len(s)
        for k in range(1, len(s)):
            if s[k] == ')':
                if s[k-1] == '(':  # ...()  形式
                    if k-2 >= 0:
                        dp[k] = dp[k-2] + 2
                    else:
                        dp[k] = 0 + 2
                # ...))形式  如果有效必然  在 k-dp[k-1]-1 位置 有 '('
                elif k-dp[k-1]-1 >= 0 and s[k-dp[k-1]-1] == '(':
                    if k-dp[k-1]-2 >= 0:
                        dp[k] = dp[k-1] + dp[k-dp[k-1]-2] + 2
                    else:
                        dp[k] = dp[k-1] + 0 + 2
                maxans = max(maxans, dp[k])
        return maxans
