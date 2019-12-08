#52. N皇后 II

       
class Solution:
    def totalNQueens(self, n): 
        if n < 1: return [] 
        self.count = 0 
        self.DFS(n, 0, 0, 0, 0) 
        return self.count

    def DFS(self, n, row, cols, pie, na): 
        # recursion terminator 
        if row >= n: 
            self.count += 1 
            return

        bits = (~(cols|pie|na))&((1<< n)- 1)  

        while bits: 
            p = bits & -bits # 取到最低位的1
            bits = bits&(bits-1) # 表示在p位置上放入皇后
            self.DFS(n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1) 
            # 不需要revert  cols, pie, na 的状态