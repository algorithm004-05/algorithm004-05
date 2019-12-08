#给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
#
# 示例 1:
#
# 输入: "(()"
#输出: 2
#解释: 最长有效括号子串为 "()"
#
#
# 示例 2:
#
# 输入: ")()())"
#输出: 4
#解释: 最长有效括号子串为 "()()"
#
# Related Topics 字符串 动态规划



#leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def longestValidParentheses1(self, s: str) -> int:
        # 暴力法  超时
        def isValidParenthese(s :str) -> bool:
            stack = []
            for i in s:
                if i == "(":
                    stack.append(i)
                elif len(stack) != 0 and stack[-1] == "(":
                    stack.pop()
                else:
                    return False
            return len(stack) == 0

        rdata = 0
        for i in range(len(s)):
            for j in range(i, len(s)):
                if isValidParenthese(s[i:j+1]):
                    rdata = max(rdata, j+1-i)

        return rdata


    def longestValidParentheses2(self, s: str) -> int:
        # DP
        n = len(s)
        if n == 0:
            return 0

        dp = [0] * n
        res = 0
        for i in range(n):
            if i > 0 and s[i] == ")":
                if s[i - 1] == "(":
                    dp[i] = dp[i - 2] + 2
                elif s[i - 1] == ")" and i - dp[i - 1] - 1 >= 0 and s[i - dp[i - 1] - 1] == "(":
                    dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2]
                if dp[i] > res:
                    res = dp[i]
        return res

#leetcode submit region end(Prohibit modification and deletion)

if __name__ == '__main__':
    s = Solution()
    print(s.longestValidParentheses2(")(()())"))