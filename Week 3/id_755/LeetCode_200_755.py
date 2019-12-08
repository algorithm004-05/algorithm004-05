class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def dfs(r, c):
            if r < 0 or r >= num_row or c < 0 or c >= num_col or grid[r][c] == "0":
                return
            grid[r][c] = "0"
            for direction_r, direction_c in zip(direction_r_lst, direction_c_lst):
                dfs(r+direction_r, c+direction_c)
        num_row = len(grid)
        if num_row == 0:
            return 0
        num_col = len(grid[0])
        count = 0
        direction_r_lst = [1, 0, -1, 0]
        direction_c_lst = [0, 1, 0, -1]
        for r in range(num_row):
            for c in range(num_col):
                if grid[r][c] != "0":
                    count += 1
                    dfs(r,c)
        return count
