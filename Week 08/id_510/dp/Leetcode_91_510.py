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
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-ways
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

"""


class Solution:
    def numDecodings(self, s: str) -> int:
        if not s or '0' == s[0]: return 0
        _len = len(s)
        if 1 >= _len: return _len
        dp = [1 for _ in range(_len)]
        s2 = {'1', '2'}
        s6 = {'1', '2', '3', '4', '5', '6'}
        if '0' == s[1] and s[0] not in s2: return 0
        if '1' == s[0] or ('2' == s[0] and s[1] in s6): dp[1] = 2
        for i in range(2, _len):
            if '0' == s[i]:
                if s[i - 1] not in s2: return 0  # 尾数为0 则前面必须为1or2
                dp[i] = dp[i - 2]  # 前i-2的位置数量+1
            elif '1' == s[i - 1] or ('2' == s[i - 1] and s[i] in s6):
                dp[i] = dp[i - 2] + dp[i - 1]
            else:
                dp[i] = dp[i - 1]  # 上一个是0 则不能与i-2的位置拆分
        return dp[-1]

    def numDecodings1(self, s: str) -> int:
        if not s or '0' == s[0]: return 0
        _len = len(s) + 1
        dp = [0 for _ in range(_len)]
        dp[0], dp[1] = 1, 1
        s6 = {'0', '1', '2', '3', '4', '5', '6'}
        for i in range(2, _len):
            if '0' != s[i - 1]:
                dp[i] = dp[i - 1]
            if '1' == s[i - 2] or ('2' == s[i - 2] and s[i - 1] in s6):
                dp[i] += dp[i - 2]
        return dp[-1]

    def numDecodings2(self, s: str) -> int:
        if not s or '0' == s[0]: return 0
        _len = len(s) + 1
        pre, next = 1, 1
        s6 = {'0', '1', '2', '3', '4', '5', '6'}
        for i in range(2, _len):
            curr = 0
            if '0' != s[i - 1]:
                curr = next
            if '1' == s[i - 2] or ('2' == s[i - 2] and s[i - 1] in s6):
                curr += pre
            pre, next = next, curr
        return next


print(Solution().numDecodings2("12120"))
