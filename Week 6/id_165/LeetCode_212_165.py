# 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
#
# 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
#
# 示例:
#
# 输入:
# words = ["oath","pea","eat","rain"] and board =
# [
#  ['o','a','a','n'],
#  ['e','t','a','e'],
#  ['i','h','k','r'],
#  ['i','f','l','v']
# ]
#
# 输出: ["eat","oath"]
#
# 说明:
# 你可以假设所有输入都由小写字母 a-z 组成。
#
# 提示:
#
#
# 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
# 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
#
# Related Topics 字典树 回溯算法


# leetcode submit region begin(Prohibit modification and deletion)

class Trie(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.head = {}
        self.end_symbol = '#'

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        current = self.head

        for c in word:

            if c not in current:
                current[c] = {}

            current = current[c]

        current[self.end_symbol] = True

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        current = self.head

        for c in word:

            if c not in current:
                return False

            current = current[c]

        return current.get(self.end_symbol, False)

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """

        current = self.head

        for c in prefix:

            if c not in current:
                return False

            current = current[c]

        return True

# DFS + Trie
class Solution(object):

    def __init__(self):

        self.visited = set()
        self.board = []
        self.vector = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        self.x_len = 0
        self.y_len = 0
        self.result = set()
        self.trie = Trie()

    def findWords(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """
        self.board = board
        self.x_len = len(self.board)
        self.y_len = len(self.board[0])

        for word in words:
            self.trie.insert(word)

        # 遍历board， 以board中每个字母作为开头做DFS
        for i in range(self.x_len):
            for j in range(self.y_len):
                self.visited = set()
                self.dfs(self.trie.head, i, j, self.board[i][j])

        return self.result

    def dfs(self, current_trie, current_x, current_y, current_word):

        self.visited.add((current_x, current_y))

        current_char = self.board[current_x][current_y]
        # 剪枝，当前字符已经不在对应的trie中了，直接返回
        if current_char not in current_trie:
            return

        # 每次trie只传当前层的，不需要每次在整棵Trie中查找，亲测可以提高一倍速度。
        if self.trie.end_symbol in current_trie[current_char]:
            self.result.add(current_word)

        for i, j in self.vector:
            # 每个节点四联通扩散，且不越界
            if 0 <= current_x + i < self.x_len \
                    and 0 <= current_y + j < self.y_len:

                if (current_x + i, current_y + j) not in self.visited:
                    next_char = self.board[current_x + i][current_y + j]
                    self.dfs(current_trie[current_char], current_x + i, current_y + j, current_word + next_char)

                    self.visited.remove((current_x + i, current_y + j))

