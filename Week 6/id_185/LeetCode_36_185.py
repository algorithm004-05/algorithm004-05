class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if not board: 
            return False

        for i in range(0, 9):
            for j in range(0, 9):
                if board[i][j] != ".":
                    row = board[i]
                    col = [board[k][j] for k in range(0, 9)]
                    sub_board = [board[m][n] for m in range(i // 3 * 3, i // 3 * 3 + 3) for n in range(j // 3 * 3, j // 3 * 3 + 3)]

                    if row.count(board[i][j]) > 1 or col.count(board[i][j]) > 1 or sub_board.count(board[i][j]) > 1:
                        return False

        return True
