## 37. 解数独
class Solution:
    def __init__(self):
        self.empty = []
        self.row = [set(range(1,10)) for _ in range(9)]
        self.col = [set(range(1,10)) for _ in range(9)]
        self.block = [set(range(1,10)) for _ in range(9)]

    def backtrack(self, board, iter=0):
        if iter == len(self.empty):
            return True
        i, j = self.empty[iter]
        n = i // 3 * 3 + j // 3
        for val in self.row[i] & self.col[j] & self.block[n]:
            self.row[i].remove(val)
            self.col[j].remove(val)
            self.block[n].remove(val)
            board[i][j] = str(val)
            if self.backtrack(board, iter+1):
                return True
            self.row[i].add(val)
            self.col[j].add(val)
            self.block[n].add(val)
        return False

    def solveSudoku(self, board: List[List[str]]) -> None:
        for i in range(len(board)):
            for j in range(len(board[0])):
                n = i // 3 * 3 + j // 3
                if board[i][j] != '.':
                    val = int(board[i][j])
                    self.row[i].remove(val)
                    self.col[j].remove(val)
                    self.block[n].remove(val)
                else:
                    self.empty.append((i, j))

        self.backtrack(board)
        