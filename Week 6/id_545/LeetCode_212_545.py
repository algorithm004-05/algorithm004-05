## 212. 单词搜索II
class Solution(object):
    def __init__(self):
        self.root = {}
        self.result = set()
        self.END = '#'
        self.xy = ((-1, 0), (1, 0), (0, -1), (0, 1)) #行列 上下左右
    
    def trie(self, word):
        node = self.root
        for char in word:
            node = node.setdefault(char, {})
        node[self.END] = self.END
    
    def dfs(self, board, row, col, cur_word, cur_dict):
        cur_word += board[row][col]
        cur_dict = cur_dict[board[row][col]]
        if self.END in cur_dict:
            self.result.add(cur_word)
        tmp, board[row][col] = board[row][col], False
        for _row, _col in self.xy:
            _row_, _col_ = _row + row, _col + col
            if -1 < _row_ < len(board) and -1 < _col_ < len(board[0]) and board[_row_][_col_] and board[_row_][_col_] in cur_dict:
                self.dfs(board, _row_, _col_, cur_word, cur_dict)
        board[row][col] = tmp

    def findWords(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """
        for word in words:
            self.trie(word)
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] in self.root:
                    self.dfs(board, i, j, '', self.root)

        return list(self.result)