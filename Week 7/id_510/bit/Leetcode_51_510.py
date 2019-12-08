"""
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



上图为 8 皇后问题的一种解法。

给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

示例:

输入: 4
输出: [
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-queens
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
from typing import List
class Solution:

    def solveNQueens(self, n: int) -> List[List[str]]:
        if n < 1: return []
        self.ppp = []
        self.count = 0
        self.DFS(n,0,0,0,0,[0 for _ in range(n)])
        for i in range(len(self.ppp)):
            for j in range(len(self.ppp[i])):
                self.ppp[i][j] = self.ppp[i][j].replace("0", ".").replace("1", "Q")
        self.ppp.reverse()
        return self.ppp

    def DFS(self, n, row, cols, pie, na, pp):
        if row >= n:
            self.count +=1
            self.ppp.append(pp.copy())
            return
        bits = (~(cols | pie | na)) & ((1 << n) - 1)         #得到当前所有的空位  cols, pie, na 中的1代表攻击的位置  bits 1代表空位  排除已占的位置
        while bits:
            p = bits & (-bits) # 获取到最低的空位 取到最低位的1
            bits = bits & (bits - 1) #占位最低位 设为0 表示在p位置上放入皇后
            pp[row] = format(p, 'b').rjust(n,'.')
            # cols | p 列占位   (pie | p) << 1 撇占位 到下一层以后要左移动一位  (na | p) >> 1 捺占位 到下一层要右移动一位
            self.DFS(n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1, pp)



print(Solution().solveNQueens(6))