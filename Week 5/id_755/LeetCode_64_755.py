class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        # use the input matrix grid instead
        # so the space complexity is O(1)
        num_rows = len(grid)
        if num_rows == 0:
            return 0
        num_cols = len(grid[0])
        for i in range(1, num_rows):
            grid[i][0] += grid[i-1][0]
        for j in range(1, num_cols):
            grid[0][j] += grid[0][j-1]
        for i in range(1, num_rows):
            for j in range(1, num_cols):
                grid[i][j] += min(grid[i-1][j], grid[i][j-1])
        return grid[-1][-1]