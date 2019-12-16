"""
给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。

示例 1:

输入: "sea", "eat"
输出: 2
解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
说明:

给定单词的长度不超过500。
给定单词中的字符只含有小写字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/delete-operation-for-two-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""


class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        if word2 == word1: return 0
        _len1, _len2 = len(word1) + 1, len(word2) + 1
        # 最长公共子序列
        dp = [[0 for _ in range(_len2)] for _ in range(_len1)]
        for i in range(_len1):
            for j in range(_len2):
                if i == 0 or j == 0: continue
                if word1[i - 1] == word2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1] + 1  # 字符相同 子长度+1
                else:
                    dp[i][j] = max(dp[i - 1][j],
                                   dp[i][j - 1])  # 最长 max 字符不同 要删除 word1删除dp[i - 1][j] 或 word2删除dp[i][j-1]

        return len(word1) + len(word2) - 2 * dp[-1][-1]

    def minDistance2(self, word1: str, word2: str) -> int:
        if word2 == word1: return 0
        _len1, _len2 = len(word1) + 1, len(word2) + 1
        dp = [[0 for _ in range(_len2)] for _ in range(_len1)]
        for i in range(_len1):
            for j in range(_len2):
                if i == 0 or j == 0:
                    dp[i][j] = i + j  # 边界值 删除word1 i 或 word2  j
                elif word1[i - 1] == word2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]  # 字符相同 不删除
                else:
                    dp[i][j] = 1 + min(dp[i - 1][j],
                                       dp[i][j - 1])  # 最少删除min 字符不同 要删除 word1删除dp[i - 1][j] 或 word2删除dp[i][j-1]
        return dp[-1][-1]

    def minDistance3(self, word1: str, word2: str) -> int:
        if word2 == word1: return 0
        _len1, _len2 = len(word1) + 1, len(word2) + 1
        dp, temp = [0 for _ in range(_len2)], [0 for _ in range(_len2)]

        # dp = [[0 for _ in range(_len2)] for _ in range(_len1)]
        # dp2[i-1][k] = dp[k] 即dp=dp2[i-1]    dp2[i][k] = temp[k-1] 即temp = dp2[i]
        for i in range(_len1):
            for j in range(_len2):
                temp[j] = 0
                if i == 0 or j == 0:
                    temp[j] = i + j  # 边界值 删除word1 i 或 word2  j
                elif word1[i - 1] == word2[j - 1]:
                    temp[j] = dp[j - 1]  # 字符相同 不删除
                else:
                    temp[j] = 1 + min(dp[j], temp[j - 1])  # 最少删除min 字符不同 要删除 word1删除dp[i - 1][j] 或 word2删除dp[i][j-1]
            dp, temp = temp, dp
        return dp[-1]


print(Solution().minDistance3("", "a"))
