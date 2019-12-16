"""
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""


class Solution:
    def longestValidParentheses(self, s: str) -> int:
        if not s: return 0
        dp = [0] * len(s)
        for i in range(1, len(s)):
            if ')' == s[i]:
                if '(' == s[i - 1]:
                    # 前一个是匹配的( 则 长度为2  再加上 i-2这个位置的数量 合计为连续的
                    dp[i] = dp[i - 2] + 2
                elif i - dp[i - 1] - 1 >= 0 and '(' == s[i - dp[i - 1] - 1]:
                    # s[i-1]为) 则 d[i-1] 记录了此位置有效的长度
                    # 则 i- d[i-1] - 1 为当前i对应匹配的位置
                    # 如果为'(' == s[i - dp[i - 1] - 1] 则匹配
                    # dp[i - 1] 前一个连续有效个数  dp[i - dp[i - 1] - 2] 匹配位置的前一个有效的个数  2 自身的个数
                    dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2
        return max(dp)

    def longestValidParentheses1(self, s: str) -> int:
        if not s: return 0
        stack, res = [-1], 0
        for i in range(len(s)):
            if '(' == s[i]:
                stack.append(i)
            else:
                stack.pop()
                if not stack:  # 空栈 则连续断开了
                    stack.append(i)
                else:
                    res = max(res, i - stack[-1])  # i - stack[-1] 当前位置的最大匹配数
        return res


print(Solution().longestValidParentheses("(()))())("))
