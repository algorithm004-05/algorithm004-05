# 单词接龙
# 法一：单向BFS
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordList = set(wordList)
        if endWord not in wordList:
            return 0
        res = []
        queue = [(beginWord, 1)]
        # 处理字符串,打辅助
        def construct_dict(wordList):
            d = {}
            for word in wordList:
                for i in range(len(word)):
                    s = word[:i] + '_' + word[i+1:]
                    d[s] = d.get(s, []) + [word]
            return d
        
        def BFS(endWord, d):
            visited = set()  # 要用visited这个集合避免重复遍历
            while queue:
                node, step = queue.pop(0)
                temp = step
                # terminator  处理上一层
                if node not in visited:
                    visited.add(node)
                    if node == endWord:
                        return step 
                # drill down
                for i, v in enumerate(node):
                    # 产生新的字符并判断是否在wordList中
                    new = node[:i] + '_' + node[i+1:]
                    new_dict = d.get(new, [])
                    for word in new_dict:   # 若new_dict为空，什么都没有
                        if word not in visited:
                            step = temp
                            queue.append((word, step + 1))
                            
            return 0
        d = construct_dict(wordList)
        return BFS(endWord, d)

# 法一：另一种优化写法（法二基于这种写法进行双向BFS）
class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        wordList = set(wordList)
        queue = collections.deque([[beginWord, 1]])
        while queue:
            word, length = queue.popleft()
            if word == endWord:
                return length
            for i in range(len(word)):
                for c in 'abcdefghijklmnopqrstuvwxyz':
                    next_word = word[:i] + c + word[i+1:]
                    if next_word in wordList:
                        wordList.remove(next_word)
                        queue.append([next_word, length + 1])
        return 0

# 法二：双向BFS
import string 
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList: return 0

        front = {beginWord}
        back = {endWord}
        dist = 1  # 走的步数
        wordList = set(wordList)
        word_len = len(beginWord)

        # BFS starts here
        while front:
            dist += 1
            next_front = set()
            for word in front:
                for i in range(word_len):
                    for c in string.ascii_lowercase: # a-z
                        if c != word[i]:
                            new_word = word[:i] + c + word[i+1:]
                            if new_word in back:
                                return dist
                            if new_word in wordList:
                                next_front.add(new_word)
                                wordList.remove(new_word)
            front = next_front

            if len(back) < len(front):
                front, back = back, front
        return 0