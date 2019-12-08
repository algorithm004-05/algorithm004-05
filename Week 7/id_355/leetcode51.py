class Solution(object):
    def solveNQueens(self, n):
        def dfs(queens, xy_sub, xy_plus):
            row = len(queens)
            if row == n:
                result.append(queens)
                return None
            for col in range(n):
                if col not in queens and col + row not in xy_plus and row - col not in xy_sub:
                    dfs(queens + [col], xy_sub + [row - col], xy_plus + [row + col])
        result = []
        dfs([], [], [])
        return [["."* i + "Q" + "."* (n -i-1) for i in s] for s in result]