# 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
#
# 示例:
#
# 输入:
#
# 1 0 1 0 0
# 1 0 1 1 1
# 1 1 1 1 1
# 1 0 0 1 0
#
# 输出: 4
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/maximal-square
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


####  思路 要成正方形 则  1. 每一个d[i][j] == 1
#                       2. 且与它相邻的所有格子都必须是1 d[i-1][j] == d[i-1][[j-1]==d[i][j-1] ==1
#                       3. 还必须满足 i = j ，改写d[i][i] == d[i-1][i]==d[i][i-1]== d[i-1][i-1] == 1

###     联想到岛屿的计数问题，广度搜索BFS，炸沉的方法


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix: return 0
        row = len(matrix)
        col = len(matrix[0])
        dp = [[0] * (col + 1) for _ in range(row + 1)]
        res = 0
        for i in range(1, row +1):
            for j in range(1, col + 1):
                if matrix[i - 1][j - 1] == "1":
                    dp[i][j] = min(dp[i-1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1
                    res = max(res, dp[i][j] ** 2)
        return res




