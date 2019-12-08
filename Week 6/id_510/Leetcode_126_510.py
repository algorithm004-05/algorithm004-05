
"""
给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回一个空列表。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出: []

解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-ladder-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

"""
from typing import List
import string
class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        if endWord not in wordList:return 0
        wordList = set(wordList)
        res,visit,_len,front,back = [],set(),len(beginWord),{beginWord:[[beginWord]]},{endWord:[[endWord]]}

        while front:
            temp = {}
            while front:
                word,paths = front.popitem()
                visit.add(word)
                for i in range(_len):
                    for c in string.ascii_lowercase:
                        if c != word[i]:
                            new_word = word[:i] + c + word[i+1:]
                            if new_word in back:
                                if paths[0][0] == beginWord: #表示当前是从beginWord开始处理的路径
                                    res.extend(fpath + bpath[::-1] for fpath in paths for bpath in back[new_word])
                                else:
                                    res.extend(bpath + fpath[::-1] for fpath in paths for bpath in back[new_word])
                            elif new_word in wordList and new_word not in visit:
                                temp[new_word] = temp.get(new_word,[]) + [path + [new_word] for path in paths]
            if res:
                break
            front = temp
            if len(front) > len(back):
                front,back = back,front
        return res





print(Solution().findLadders("hit","cog", ["hot","dot","dog","lot","log","cog"]))

print(Solution().findLadders("hit","cog",["hot","dot","dog","lot","log"]))