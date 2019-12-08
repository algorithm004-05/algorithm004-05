# 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
#
#
# 每次转换只能改变一个字母。
# 转换过程中的中间单词必须是字典中的单词。
#
#
# 说明:
#
#
# 如果不存在这样的转换序列，返回 0。
# 所有单词具有相同的长度。
# 所有单词只由小写字母组成。
# 字典中不存在重复的单词。
# 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
#
#
# 示例 1:
#
# 输入:
# beginWord = "hit",
# endWord = "cog",
# wordList = ["hot","dot","dog","lot","log","cog"]
#
# 输出: 5
#
# 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
#     返回它的长度 5。
#
#
# 示例 2:
#
# 输入:
# beginWord = "hit"
# endWord = "cog"
# wordList = ["hot","dot","dog","lot","log"]
#
# 输出: 0
#
# 解释: endWord "cog" 不在字典中，所以无法进行转换。
# Related Topics 广度优先搜索


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def __init__(self):

        self.beginWord = ''
        self.endWord = ''
        self.wordList = []
        self.possible_words = {}
        self.queue = []
        self.visited = {}

    def pre_classify(self):

        word_length = len(self.beginWord)
        for word in self.wordList:
            for i in range(word_length):
                temp_word = word[0:i] + '*' + word[i+1:]
                if temp_word in self.possible_words:
                    self.possible_words[temp_word].append(word)
                else:
                    self.possible_words[temp_word] = [word]

    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        self.beginWord = beginWord
        self.endWord = endWord
        self.wordList = wordList

        self.pre_classify()

        self.queue.append((beginWord, 1))

        res = self._bfs()
        return res if res else 0

    def _bfs(self):

        while self.queue:

            current_process, current_lvl = self.queue.pop(0)
            self.visited[current_process] = True

            for i, _ in enumerate(current_process):

                temp_word = current_process[0:i] + '*' + current_process[i+1:]

                for w in self.possible_words.get(temp_word, []):

                    if w == self.endWord:

                        return current_lvl + 1
                    # 没有visit过的会被加入Queue作为下一层visit一遍，需要去除
                    if not self.visited.get(w):

                        self.queue.append((w, current_lvl + 1))

                        self.visited[w] = True

# leetcode submit region end(Prohibit modification and deletion)
