"""
给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

示例:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true.
给定 word = "SEE", 返回 true.
给定 word = "ABCB", 返回 false.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
from typing import List
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        visiter,visiter1,dxy,i_len,j_len,w_len = set(),set(),((0,1),(1,0),(0,-1),(-1,0)),len(board),len(board[0]),len(word)-1
        def dfs(i,j,board,word,index,visiter): # word index 可以转化成字典树
            if word[index:index+1] != board[i][j]:
                return False
            if index == w_len:
                return True # 字典树结尾用标识符普安的
            for (dx,dy) in dxy:
                _i,_j = i+dx,j+dy
                if (0 <= _i < i_len and 0<=_j <j_len and (_i,_j) not in visiter):
                    if dfs(_i, _j,board, word, index + 1,visiter.union({(_i,_j)})):
                        return True
            return False

        for i in range(i_len):
            for j in range(j_len):
                if dfs(i, j, board, word, 0, {(i, j)}):
                    return True
        return False
    def exist1(self, board: List[List[str]], word: str) -> bool:
        dxy,i_len,j_len = ((0,1),(1,0),(0,-1),(-1,0)),len(board),len(board[0])
        def dfs(i,j,board,word): # word index 可以转化成字典树
            if not word:
                return True # 字典树结尾用标识符普安的
            temp, board[i][j] = board[i][j], "#"
            for (dx,dy) in dxy:
                _i,_j = i+dx,j+dy
                if (0 <= _i < i_len and 0<=_j <j_len and "#" != board[_i][_j] and word[0:1] ==  board[_i][_j]):
                    if dfs(_i, _j,board, word[1:]):
                        return True
            board[i][j] = temp

            return False

        for i in range(i_len):
            for j in range(j_len):
                if word[0:1] == board[i][j] and dfs(i, j, board, word[1:]):
                    return True
        return False

board =[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

print(Solution().exist1(board,"ABCCE"))