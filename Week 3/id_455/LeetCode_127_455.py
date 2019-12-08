#
# @lc app=leetcode.cn id=127 lang=python3
#
# [127] 单词接龙
#

# @lc code=start
import collections
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        
        if endWord not in wordList or not beginWord or not endWord or not wordList:
            return 0
        
        self.lenth = len(beginWord)

        self.comb_all_dict = collections.defaultdict(list)

        for word in wordList:
            for i in range(self.lenth):
                self.comb_all_dict[ word[ : i ] + '*' + word[ i + 1 : ] ].append(word)
     #   print(self.comb_all_dict)
        visited_begin = {beginWord:1}
        visited_end = {endWord:1}

        queue_begin = [ (beginWord, 1) ]
        queue_end = [ (endWord, 1) ]


        ans = None

        while queue_begin and queue_end:

            ans = self.__visitedWord(queue_begin, visited_begin, visited_end)
            if ans:
                return ans

            ans = self.__visitedWord(queue_end, visited_end, visited_begin)
            if ans:
                return ans

        return 0

    def __visitedWord(self, queue, visited, otherVisited):
        word, level = queue.pop(0)

        for i in range(self.lenth):
            temWord = word[ : i ] + '*' + word[ i + 1 : ]
            for currWord in self.comb_all_dict[temWord]:
                if currWord in otherVisited:    # or: if currWord in otherVisited.keys()
                    return level + otherVisited[currWord]
                if currWord not in visited:
                    visited[currWord] = level + 1
                    queue.append( (currWord, level + 1) )
            self.comb_all_dict[temWord] = []

        return None
# @lc code=end

