class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        num_rows = len(grid)
        if num_rows == 0:
            return 0
        num_cols = len(grid[0])
        # used for dfs
        row_dir_lst = [0, 1]
        col_dir_lst = [1, 0]
        res_lst = []

        """# using dfs
        def dfs(row, col, curr_sum):
            if row < 0 or row >= num_rows or col < 0 or col >= num_cols:
                return
            if row == num_rows - 1 and col == num_cols - 1:
                res_lst.append(curr_sum+grid[row][col])
                return
            for row_dir, col_dir in zip(row_dir_lst, col_dir_lst):
                dfs(row+row_dir, col+col_dir, curr_sum+grid[row][col])
        dfs(0, 0, 0)
        return min(res_lst)"""
        # using dp with O(m*n) space complexity
        """opt = [[0 for _ in range(num_cols)] for _ in range(num_rows)]
        opt[0][0] = grid[0][0]
        for i in range(1, num_cols):
            opt[0][i] = opt[0][i-1] + grid[0][i]
        for i in range(1, num_rows):
            opt[i][0] = opt[i-1][0] + grid[i][0]
        for i in range(1, num_rows):
            for j in range(1, num_cols):
                opt[i][j] = min(opt[i-1][j], opt[i][j-1]) + grid[i][j]
        return opt[-1][-1]"""

        # using dp with O(n) space complexity
        """opt = [0 for _ in range(num_cols)]
        opt[0] = grid[0][0]
        for j in range(1, num_cols):
            opt[j] = opt[j-1] + grid[0][j]
        for i in range(1, num_rows):
            for j in range(num_cols):
                if j == 0:
                    opt[j] += grid[i][j]
                else:
                    opt[j] = min(opt[j-1], opt[j]) + grid[i][j]
        return opt[-1]"""

        # using dp with O(1) space complexity
        for i in range(1, num_rows):
            grid[i][0] += grid[i - 1][0]
        for j in range(1, num_cols):
            grid[0][j] += grid[0][j - 1]
        for i in range(1, num_rows):
            for j in range(1, num_cols):
                grid[i][j] += min(grid[i - 1][j], grid[i][j - 1])
        return grid[-1][-1]
