#给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
#
# 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
#
# 示例:
#
# X X X X
#X O O X
#X X O X
#X O X X
#
#
# 运行你的函数后，矩阵变为：
#
# X X X X
#X X X X
#X X X X
#X O X X
#
#
# 解释:
#
# 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
# Related Topics 深度优先搜索 广度优先搜索 并查集



#leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def solve(self, board: list) -> None:
        """ 深度优先搜索 """
        if not board: return
        row = len(board)
        col = len(board[0])

        if row < 3 or col < 3: return
        # DFS函数
        def dfs(i, j):
            if i < 0 or j < 0 or i >= row or j >= col or board[i][j] != 'O':
                return
            board[i][j] = '#'
            dfs(i - 1, j)
            dfs(i + 1, j)
            dfs(i, j - 1)
            dfs(i, j + 1)

        for i in range(row):
            dfs(i, 0)
            dfs(i, col - 1)

        for i in range(col):
            dfs(0, i)
            dfs(row - 1, i)

        for i in range(0, row):
            for j in range(0, col):
                if board[i][j] == 'O':
                    board[i][j] = 'X'
                if board[i][j] == '#':
                    board[i][j] = 'O'


#leetcode submit region end(Prohibit modification and deletion)

if __name__ == '__main__':
    s = Solution()
    board = [
        ["X", "X", "X", "X"],
        ["X", "O", "O", "X"],
        ["X", "X", "O", "X"],
        ["X", "O", "X", "X"],
    ]

    s.solve(board)

    for b in board:
        print(b)
