#
# @lc app=leetcode.cn id=51 lang=python3
#
# [51] N皇后
#

# @lc code=start
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        cols = set()
        xy_diff = set()
        xy_sum = set()


        def queens(row, n, ls1, res = []):
            if row >= n:
                res.append(ls1)
                return

            for col in range(n):
                if col in cols or row + col in xy_sum or row - col in xy_diff:
                    continue
                
                cols.add(col)
                xy_sum.add(row + col)
                xy_diff.add(row - col)
                queens(row + 1, n, ls1 + [col])

                cols.remove(col)
                xy_sum.remove(row + col)
                xy_diff.remove(row - col)
            return res
        res = queens(0, n, [])
        def generate(res):
            result = []
            for ls in res:
                subls = ['.' * n ] * n
                for i in range(n):
                    lstem = list(subls[i])
                    lstem[ls[i]] = 'Q'
                    subls[i] = ''.join(lstem) 
                result.append(subls)
            return result

        return generate(res)


        
# @lc code=end

