#
# @lc app=leetcode.cn id=51 lang=python3
#
# [51] N皇后
#

# @lc code=start
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:

    # 方法一，超哥在课上给的方法，说实话代码挺简洁，相比LeetCode高票答案，也没太炫技，点赞

    #  使用 pie 和 na 进行判重的作用，实际上就是用来剪枝
    #     if n < 1: return []

    #     self.result = []

    #     # 之前的皇后所能够攻击的位置（列、pie，na）
    #     # 这里其实可以不用调用set()函数，因为已经手动remove过了，不需要利用set去重
    #     self.cols = set()
    #     self.pie = set()
    #     self.na = set()

    #     self.DFS(n, 0 ,[])
    #     return self._generate_result(n)
    
    # def DFS(self, n, row, cur_state):
    #     # recursion terminator
    #     # 到了最后一层，就把结果添加到结果集里面
    #     if row >= n:
    #         self.result.append(cur_state)
    #         return

    #     ## current level! Do it! ，核心逻辑是在当前这一层遍历所有列
    #     for col in range(n): #在某一行中，遍历所有 column
    #         if col in self.cols or row+col in self.pie or row-col in self.na:
    #             # go die!
    #             continue
                
    #         #把皇后放在列上，然后更新
    #         # update the flags
    #         self.cols.add(col)
    #         self.pie.add(row + col)
    #         self.na.add(row-col)

    #         self.DFS(n, row+1, cur_state+[col])

    #         #reverse state
    #         self.cols.remove(col)
    #         self.pie.remove(row + col)
    #         self.na.remove(row - col)

    # def _generate_result(self, n):
    #     board=[]
    #     for res in self.result:
    #         for i in res:
    #             board.append("." * i + "Q" + "." * (n - i - 1))
        
    #     return [board[i : i+n] for i in range(0, len(board), n)]

    # 方法二，LeetCode高票解法,第二级别的终极解法(除了位运算的方法)
        def DFS(queens, xy_dif, xy_sum):
            p = len(queens)
            if p == n:
                result.append(queens)
                return None
            for q in range(n):
                if q not in queens and p-q not in xy_dif and p+q not in xy_sum:
                    DFS(queens+[q], xy_dif+[p-q], xy_sum+[p+q])
        result = []
        DFS([],[],[])
        return [["."*i+"Q"+"."*(n-i-1) for i in sol] for sol in result]




# @lc code=end

