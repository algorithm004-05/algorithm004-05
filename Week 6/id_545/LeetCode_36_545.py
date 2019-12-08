## 36. 有效的数独

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        block = collections.defaultdict(list)
        for i in range(len(board)):
            row, col = set(), set()
            for j in range(len(board[0])):
                n = i // 3 * 3 + j // 3
                if board[i][j] in row or board[j][i] in col or board[i][j] in block[n]:
                    return False
                if board[i][j] != '.':
                    row.add(board[i][j])
                    block[n].append(board[i][j])
                if board[j][i] != '.':
                    col.add(board[j][i])
        return True