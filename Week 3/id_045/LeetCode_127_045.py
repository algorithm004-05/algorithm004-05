# @author:leacoder
# @des:  广度优先搜索 单词接龙 


'''
将问题抽象在一个无向无权图中，每个单词作为节点，差距只有一个字母的两个单词之间连一条边。
问题变成找到从起点到终点的最短路径，如果存在的话。因此可以使用广度优先搜索方法。

预处理 构建 ｛通用状态:单词｝ 字典，将单词中的某个字母用 * 代替


时间复杂度：O(M×N)，其中 M 是单词的长度 N 是单词表中单词的总数。
空间复杂度：O(M×N)，要在 all_combo_dict 字典中记录每个单词的 M 个通用状态。访问数组的大小是 N。
'''

from collections import defaultdict
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:

        if endWord not in wordList or not endWord or not beginWord or not wordList:
            return 0

        # 迭代前处理

        # 预处理 构建 ｛通用状态:单词｝ 字典
        L = len(beginWord)  # 所有单词具有相同的长度
        all_combo_dict = defaultdict(list)  # 字典 记录所有的通用状态  ｛通用状态:单词｝
        for word in wordList:   # 遍历所有单词
            for i in range(L):  # 每次转换只能改变一个字母 所以用*替换改变字母 
                all_combo_dict[word[:i] + "*" + word[i+1:]].append(word)    # ｛通用状态:单词｝

        queue = [(beginWord, 1)] # 辅助队列  1 代表节点的层次  入队列
        visited = {beginWord: True}    # 被访问记录

        # 迭代
        while queue:    # 迭代终止条件
            current_word, level = queue.pop(0)   # 出队列

            # 生成相关节点
            for i in range(L):  # 当前单词的所有通用状态
                intermediate_word = current_word[:i] + "*" + current_word[i+1:]

                # 当前通用状态 对应的单词
                for word in all_combo_dict[intermediate_word]:

                    if word == endWord: # 找到 endWord 目标单词，层次加1 退出
                        return level + 1

                    # 没有看是否处理过
                    if word not in visited:
                        # 没有处理 处理并设置标志位
                        visited[word] = True
                        queue.append((word, level + 1)) # 将单词入队列
                    else:
                        continue

        return 0   # 不存在这样的转换序列，返回 0

      





