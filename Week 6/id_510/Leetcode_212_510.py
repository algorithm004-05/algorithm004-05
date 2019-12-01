"""
给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。

示例:

输入:
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

输出: ["eat","oath"]
说明:
你可以假设所有输入都由小写字母 a-z 组成。

提示:

你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
from typing import List


def ii(args):
    pass


class Solution:

    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        trie,res,i_len,j_len,dxy = {},set(),len(board),len(board[0]), ((0, 1), (1, 0), (0, -1), (-1, 0))  # 上 右 下 左  0  90 180  270
        for w in words:
            node = trie #字典树
            for c in w:
                node = node.setdefault(c,{})
            node["#"] = "#"
        #print(trie)
        def dfs(node, pre, i, j, visited):
            #print(i, j, pre,node,visited)
            if "#" in node:
                res.add(pre)
                #print(pre)
            for (di,dj) in dxy:
                _i,_j = i+di,j+dj
                if 0 <= _i < i_len and 0 <= _j < j_len and board[_i][_j] in node and (_i,_j) not in visited:
                    dfs(node[board[_i][_j]],pre + board[_i][_j],_i,_j,visited.union({(_i,_j)}))

        ["" for i in range(i_len) for j in range(j_len) if board[i][j] in trie if dfs(trie[board[i][j]],board[i][j],i,j,{(i,j)})]
        return res

words = ["eoath","oath","pea","eat","rain","aak","nerklf"]
board =[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

print(Solution().findWords(board,words))






