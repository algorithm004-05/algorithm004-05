"""
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



上图为 8 皇后问题的一种解法。

给定一个整数 n，返回 n 皇后不同的解决方案的数量。

示例:

输入: 4
输出: 2
解释: 4 皇后问题存在如下两个不同的解法。
[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-queens-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""


class Solution:
    def totalNQueens(self, n: int) -> int:
        if n < 1: return []
        self.count = 0
        self.DFS(n, 0, 0, 0, 0)
        return self.count

    def DFS(self, n, row, cols, pie, na):

        # print(row, cols, pie, na)
        print(row)
        # print(row,bin(row),bin(cols),bin(pie),bin(na))
        print(row, "==", format(cols, 'b'), format(pie, 'b'), format(na, 'b'))
        # recursion terminator
        if row >= n:
            self.count += 1
            print(row, "+1")
            return
        # cols, pie, na 中的1代表攻击的位置
        # bits 1代表空位  排除已占的位置
        bits = (~(cols | pie | na)) & ((1 << n) - 1)  # 得到当前所有的空位
        while bits:
            print(row, "==", format(bits, 'b'), "得到当前所有的空位")
            #获取到最低的空位
            p = bits & (-bits)  # 取到最低位的1
            print(row, "==", format(p, 'b'), "p取到最低位的1")
            # 占位最低位 设为0
            bits = bits & (bits - 1)  # 表示在p位置上放入皇后
            print(row, "==", format(bits, 'b'), "表示在p位置上放入皇后")
            # cols | p 列占位   (pie | p) << 1 撇占位 到下一层以后要左移动一位  (na | p) >> 1 捺占位 到下一层要右移动一位
            self.DFS(n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1)
        print(row, "==", format(bits, 'b'), "结束")
        # 不需要revert  cols, pie, na 的状态


    def DFS1(self,n,row,cols,pie,na):
        if row >= n:
            self.count +=1
            return
        bits = (~(cols|pie|na)) & ((1<<n)-1)
        while bits:
            p = bits & (-bits)
            bits = bits & (bits-1)
            self.DFS1(n,row+1,cols|p,(pie|p)<<1,(na|p)>>1)

    def DFS2(self,n,row,cols,pie,na,pp):
        if row >= n:
            return pp
        bits = (~(cols|pie|na)) & ((1<<n)-1)
        while bits:
            p = bits & (-bits)
            bits = bits & (bits-1)
            self.DFS2(n,row+1,cols|p,(pie|p)<<1,(na|p)>>1,pp)
        return []

print(Solution().totalNQueens(6))
