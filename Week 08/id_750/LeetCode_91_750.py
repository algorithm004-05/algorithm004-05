"""
一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:

输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2:

输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6)
"""


class Solution:
    def numDecodings(self, s: str) -> int:
        dp = [0] * len(s)
        if s[0] == "0":
            return 0
        else:
            dp[0] = 1
        if len(s) == 1: return dp[-1]
        if s[1] != "0":
            dp[1] += 1
        if 10 <= int(s[:2]) <= 26:
            dp[1] += 1
        for i in range(2, len(s)):
            if s[i - 1] + s[i] == "00": return 0
            if s[i] != "0":
                dp[i] += dp[i - 1]
            if 10 <= int(s[i - 1] + s[i]) <= 26:
                dp[i] += dp[i - 2]
        return dp[-1]


if __name__ == '__main__':
    solution = Solution()

    s = "12"
    result = solution.numDecodings(s)
    print(result)
