# 单词搜索II——Trie
# 第一遍
import collections
# 四连通
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
end_of_word = '#'

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        if not board or not board[0]:
            return []
        if not words:
            return []
        self.result = set()  # 去重

        # 构建Trie
        root = collections.defaultdict()
        for word in words:
            node = root
            for char in word:
                node = node.setdefault(char, collections.defaultdict())
            node[end_of_word] = end_of_word
        
        # 遍历board，进行DFS
        self.m, self.n = len(board), len(board[0])
        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] in root:
                    self._dfs(board, i, j, "", root)
        return list(self.result)

    def _dfs(self, board, i, j, cur_word, cur_dict):
        # terminator
        cur_word += board[i][j]
        cur_dict = cur_dict[board[i][j]]
        if end_of_word in cur_dict:
            self.result.add(cur_word)
        # process current level
        tmp, board[i][j] = board[i][j], '@'
        for k in range(4):
            x, y = i + dx[k], j + dy[k]
            # drill down
            if 0 <= x < self.m and 0 <= y < self.n and board[x][y] != '@' and board[x][y] in cur_dict:
                self._dfs(board, x, y, cur_word, cur_dict)
        # 恢复当前层状态
        board[i][j] = tmp