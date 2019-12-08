# class Solution(object):
#     def minDistance(self, word1, word2):
#         """
#         :type word1: str
#         :type word2: str
#         :rtype: int
#         """
#         n1 = len(word1)
#         n2 = len(word2)
#         dp = [[0] * (n2 + 1) for _ in range(n1 + 1)]
#         for j in range(1, n2 + 1):
#             dp[0][j] = dp[0][j-1] + 1
#         for i in range(1, n1 + 1):
#             dp[i][0] = dp[i-1][0] + 1
#         for i in range(1, n1 + 1):
#             for j in range(1, n2 + 1):
#                 if word1[i-1] == word2[j-1]:
#                     dp[i][j] = dp[i-1][j-1]
#                 else:
#                     dp[i][j] = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1] ) + 1
#         #print(dp)      
#         return dp[-1][-1]


class Solution(object):
    def minDistance(self, word1, word2):
        l1, l2 = len(word1)+1, len(word2)+1
        pre = [0 for _ in xrange(l2)]
        for j in xrange(l2):
            pre[j] = j
        for i in xrange(1, l1):
            cur = [i]*l2
            for j in xrange(1, l2):
                cur[j] = min(cur[j-1]+1, pre[j]+1, pre[j-1]+(word1[i-1]!=word2[j-1]))
            pre = cur[:]
        return pre[-1]

