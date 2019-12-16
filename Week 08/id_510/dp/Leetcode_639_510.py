"""
一条包含字母 A-Z 的消息通过以下的方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
除了上述的条件以外，现在加密字符串可以包含字符 '*'了，字符'*'可以被当做1到9当中的任意一个数字。

给定一条包含数字和字符'*'的加密信息，请确定解码方法的总数。

同时，由于结果值可能会相当的大，所以你应当对10^9 + 7取模。（翻译者标注：此处取模主要是为了防止溢出）

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-ways-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
示例 1 :

输入: "*"
输出: 9
解释: 加密的信息可以被解密为: "A", "B", "C", "D", "E", "F", "G", "H", "I".
示例 2 :

输入: "1*"
输出: 9 + 9 = 18（翻译者标注：这里1*可以分解为1,* 或者当做1*来处理，所以结果是9+9=18）
说明 :

输入的字符串长度范围是 [1, 105]。
输入的字符串只会包含字符 '*' 和 数字'0' - '9'。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-ways-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

"""


class Solution:

    def numDecodings(self, s: str) -> int:
        if not s or '0' == s[0]: return 0
        _len = len(s) + 1
        dp = [0 for _ in range(_len)]
        dp[0], dp[1] = 1, 1
        s6 = {'0', '1', '2', '3', '4', '5', '6'}
        if '*' == s[0]: dp[1] = 9
        for i in range(2, _len):
            if '0' == s[i - 1]:
                if '1' == s[i - 2] or '2' == s[i - 2]:
                    dp[i] = dp[i - 2]
                elif '*' == s[i - 2]:
                    dp[i] = dp[i - 2] * 2
            elif s[i - 1] in s6:
                dp[i] = dp[i - 1]
                if '1' == s[i - 2] or '2' == s[i - 2]:
                    dp[i] += dp[i - 2]
                elif '*' == s[i - 2]:
                    dp[i] += dp[i - 2] * 2
            elif s[i - 1] not in s6:
                dp[i] = dp[i - 1]
                if '*' == s[i - 2] or '1' == s[i - 2]:
                    dp[i] += dp[i - 2]
            elif '*' == s[i - 1]:
                dp[i] = dp[i - 1] * 9
                if '1' == s[i - 2]:
                    dp[i] += dp[i - 2] * 9
                elif '2' == s[i - 2]:
                    dp[i] += dp[i - 2] * 6
                elif '*' == s[i - 2]:
                    dp[i] += dp[i - 2] * 15
            dp[i] %= 1000000007  # 应当对10^9 + 7取模
        return dp[-1]

    def numDecodings1(self, s: str) -> int:
        if not s or '0' == s[0]: return 0
        _len = len(s) + 1
        s6 = {'0', '1', '2', '3', '4', '5', '6'}
        """
        
        0 0
        1 dp[i] = dp[i-1]
        2 dp[i] = dp[i-1]*9
        3 dp[i] = dp[i-1] + dp[i-2]
        4 dp[i] = dp[i-1]*9 + dp[i-2]*9
        5 dp[i] = dp[i-2]
        6 dp[i] = dp[i-1]*9 + dp[i-2]*6
        7 dp[i] = dp[i-2] * 2
        8 dp[i] = dp[i-1] + dp[i-2] * 2
        9 dp[i] = dp[i-1] + dp[i-2]
        10dp[i] = dp[i-1]*9 + dp[i-2] * 15
        """
        # f[index-2][index-1]
        f = [[0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
             [5, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4],
             [5, 3, 3, 3, 3, 3, 3, 1, 1, 1, 6],
             [0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
             [0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
             [0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
             [0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
             [0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
             [0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
             [0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
             [7, 8, 8, 8, 8, 8, 8, 9, 9, 9, 10]
             ]
        f[0][0] = 0
        # f[index-2][index-1]
        for i in range(11):
            for j in range(11):
                if i == 0 and j == 10:
                    f[i][j] = 2  # dp[i] = dp[i-1]*9
                elif i == 10:

                    pass
                if j == 0:
                    if i == 10:
                        f[i][j] = 4  # dp[i] = dp[i-2]*2
                    elif i == 1 or i == 2:
                        f[i][j] = 3  # dp[i] = dp[i-2]
                    else:
                        f[i][j] = 0

        dp = [0 for _ in range(_len)]
        dp[0], dp[1] = 1, 1


print(Solution().numDecodings("904"))
