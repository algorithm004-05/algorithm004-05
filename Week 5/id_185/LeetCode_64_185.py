class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        if not grid: return 0

        row = len(grid)
        col = len(grid[0])

        for j in range(1, col):
            grid[0][j] += grid[0][j - 1]

        for i in range(1, row):
            grid[i][0] += grid[i - 1][0]

        for i in range(1, row):
            for j in range(1, col):
                grid[i][j] += min(grid[i - 1][j], grid[i][j - 1])

        return grid[row - 1][col - 1]
