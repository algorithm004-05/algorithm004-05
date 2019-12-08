# @author:leacoder 
# @des:  位运算 + DFS 深度优先  N皇后II
class Solution:
    def totalNQueens(self, n: int) -> int:
        if n < 1: return []
        self.count = 0
        self.DFS(n,0,0,0,0) #从第一行开始   由于棋盘第一行没有放任何皇后那么 row 行 cols 列 pie 撇 na 捺 位没有不可放置的
        return self.count
    
    def DFS(self, n, row, cols, pie, na):
        if row >= n: #递归终止条件  深度搜索 n 个皇后均已放在棋盘上
            self.count += 1
            return
        # col | pie | na  (1 表示被攻击, 或了以后 得到本行 所有被攻击位置 )
        # ~( col | pie | na )  0 表示被攻击位  1 表示可放置位
        # (( 1<<n ) - 1)   形成 n位全1的二进制 筛子  用于 筛选出 n 位内的有效数据
        bits = ( ~( cols | pie | na )) & (( 1<<n ) - 1)
        
        while bits:
            p = bits & (-bits)  # 取出最低位的1 也就是最低位可以放置 皇后Q的位置
            # row + 1 下移一层   cols | p : p 上放置 Q 后  cols 列方向被攻击位刷新
            # (pie | p) << 1 下一层 pie撇方向被攻击位置刷新
            # (na | p) >> 1 下一层 na 捺方向被攻击位置刷新
            self.DFS(n , row + 1, cols | p, (pie | p) << 1, (na | p) >> 1)  # 递归处理下一层
            bits = bits & (bits - 1) #去掉最低位的 1 （表示这种可能已被探寻）
        