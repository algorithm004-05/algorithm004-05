from collections import defaultdict

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList or not endWord or not beginWord or not wordList:
            return 0

        L = len(beginWord)
        all_combo_dic = defaultdict(list)
        for word in wordList:
            for i in range(L):
                all_combo_dic[word[:i] + "*" + word[i+1:]].append(word)

        queue = [(beginWord, 1)]

        visted = {beginWord: True}
        while queue:
            current_word, level = queue.pop(0)
            for i in range(L):
                intermediate_word = current_word[:i] + "*" +current_word[i+1:]

                for word in all_combo_dic[intermediate_word]:
                    if word == endWord:
                        return level + 1
                    if word not in visted:
                        visted[word] = True
                        queue.append((word, level+1))
                all_combo_dic[intermediate_word] = []
        return 0