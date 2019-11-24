# class Solution(object):
#     def minimumTotal(self, triangle):
#         """
#         :type triangle: List[List[int]]
#         :rtype: int
#         """
#         mini, M = triangle[-1], len(triangle)
#         for i in range(M-2, -1, -1):
#             for j in range(len(triangle[i])):
#                 mini[j] = triangle[i][j] + min(mini[j],mini[j+1])
#         return mini[0]

class Solution(object):
    def minimumTotal(self,triangle):
        dp = triangle
        for i in range(len(triangle)-2, -1, -1):
            for j in range(len(triangle[i])):
                dp[i][j] += min(dp[i+1][j],dp[i+1][j+1])
        print(triangle[0][0])
        return dp[0][0]