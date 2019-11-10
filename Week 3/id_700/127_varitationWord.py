# 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
#
# 每次转换只能改变一个字母。
# 转换过程中的中间单词必须是字典中的单词。
# 说明:
#
# 如果不存在这样的转换序列，返回 0。
# 所有单词具有相同的长度。
# 所有单词只由小写字母组成。
# 字典中不存在重复的单词。
# 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
# 示例 1:
#
# 输入:
# beginWord = "hit",
# endWord = "cog",
# wordList = ["hot","dot","dog","lot","log","cog"]
#
# 输出: 5
#
# 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
#      返回它的长度 5。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/word-ladder
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


##### 广度优先搜索

######    对给定的 wordList 做预处理，找出所有的通用状态。将通用状态记录在字典中，键是通用状态，值是所有具有通用状态的单词。


from  collections import defaultdict
class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):

        ####  边界条件

        if endWord not in wordList or not beginWord or not endWord or not wordList:
            return 0   ####  不要忘了是return 0 ！！！

        ####  中间状态存储在字典
        size = len(beginWord)
        all_com_dict = defaultdict(list)
        for word in wordList:
            for i in range(size):
                all_com_dict[word[:i]+"*"+word[i+1:]].append(word)  #### 将中间状态存储在字典中，用通配符对应

        ####  开始广度优先搜索  BFS，记得记录搜索过的位点


        queue = [(beginWord, 1)]  ### 此处为第一层，不是第0层，不要一直搞错！！！
        visited={beginWord: True}   ##### 要记得记录搜索过的结点！！！！

        while queue:
            current_word,level = queue.pop(0)  ###### 先进先出，queue此处以数组形式，需要指定pop的位点，
            for j  in range(size):
                intermediate_word=current_word[:j] + "*" + current_word[j + 1:]

                for word in all_com_dict[intermediate_word]:  #####  对中间通配状态所对应的word
                    if word == endWord:
                        return level+1
                    if word not in visited:
                        visited[word] = True
                        queue.append((word, level + 1))
                all_com_dict[intermediate_word] = []
        return 0

##### 解答错误？！！！！是因为return 忘了写0




参考代码：


class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """

        if endWord not in wordList or not endWord or not beginWord or not wordList:
            return 0

        # Since all words are of same length.
        L = len(beginWord)

        # Dictionary to hold combination of words that can be formed,
        # from any given word. By changing one letter at a time.
        all_combo_dict = defaultdict(list)
        for word in wordList:
            for i in range(L):
                # Key is the generic word
                # Value is a list of words which have the same intermediate generic word.
                all_combo_dict[word[:i] + "*" + word[i+1:]].append(word)


        # Queue for BFS
        queue = [(beginWord, 1)]
        # Visited to make sure we don't repeat processing same word.
        visited = {beginWord: True}
        while queue:
            current_word, level = queue.pop(0)
            for i in range(L):
                # Intermediate words for current word
                intermediate_word = current_word[:i] + "*" + current_word[i+1:]

                # Next states are all the words which share the same intermediate state.
                for word in all_combo_dict[intermediate_word]:
                    # If at any point if we find what we are looking for
                    # i.e. the end word - we can return with the answer.
                    if word == endWord:
                        return level + 1
                    # Otherwise, add it to the BFS Queue. Also mark it visited
                    if word not in visited:
                        visited[word] = True
                        queue.append((word, level + 1))
                all_combo_dict[intermediate_word] = []
        return 0




























